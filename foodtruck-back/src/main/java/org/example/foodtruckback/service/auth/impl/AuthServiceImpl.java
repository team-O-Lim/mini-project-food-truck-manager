package org.example.foodtruckback.service.auth.impl;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.foodtruckback.common.enums.ErrorCode;
import org.example.foodtruckback.common.enums.RoleType;
import org.example.foodtruckback.dto.ResponseDto;
import org.example.foodtruckback.dto.auth.request.FindIdRequestDto;
import org.example.foodtruckback.dto.auth.request.LoginRequestDto;
import org.example.foodtruckback.dto.auth.request.PasswordResetRequest;
import org.example.foodtruckback.dto.auth.request.SignupRequestDto;
import org.example.foodtruckback.dto.auth.response.FindIdResponseDto;
import org.example.foodtruckback.dto.auth.response.LoginResponseDto;
import org.example.foodtruckback.dto.auth.response.PasswordVerifyResponseDto;
import org.example.foodtruckback.dto.auth.response.SignupResponseDto;
import org.example.foodtruckback.entity.auth.RefreshToken;
import org.example.foodtruckback.entity.user.Role;
import org.example.foodtruckback.entity.user.User;
import org.example.foodtruckback.exception.BusinessException;
import org.example.foodtruckback.repository.auth.RefreshTokenRepository;
import org.example.foodtruckback.repository.user.RoleRepository;
import org.example.foodtruckback.repository.user.UserRepository;
import org.example.foodtruckback.security.provider.JwtProvider;
import org.example.foodtruckback.security.user.UserPrincipalMapper;
import org.example.foodtruckback.security.util.CookieUtils;
import org.example.foodtruckback.service.auth.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserPrincipalMapper userPrincipalMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    private static final String REFRESH_TOKEN = "refreshToken";

    // 회원 가입
    @Override
    @Transactional
    public ResponseDto<SignupResponseDto> sign(SignupRequestDto request) {

        if (userRepository.findByLoginId(request.login()).isPresent()) {
            throw new BusinessException(ErrorCode.DUPLICATE_USER);
        }

        if (!request.password().equals(request.confirmPassword())) {
            throw new BusinessException(ErrorCode.PASSWORD_CONFIRM_MISMATCH);
        }

        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);
        }

        User newUser = User.builder()
                .name(request.name())
                .loginId(request.login())
                .password(passwordEncoder.encode(request.password()))
                .email(request.email())
                .phone(request.phone())
                .build();

        Role defaultRole = roleRepository.getReferenceById(RoleType.USER);
        newUser.addRole(defaultRole);

        userRepository.save(newUser);

        return ResponseDto.success("회원가입을 성공하였습니다.", SignupResponseDto.from(newUser));
    }

    // 로그인
    @Override
    @Transactional
    public ResponseDto<LoginResponseDto> login(LoginRequestDto request, HttpServletResponse response) {

        User login = userRepository.findByLoginId(request.loginId())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        try {
            var authToken = new UsernamePasswordAuthenticationToken(
                    request.loginId(), request.password()
            );

            var authentication = authenticationManager.authenticate(authToken);

            String loginId = authentication.getName();

            var principal = userPrincipalMapper.toPrincipal(loginId);
            Set<String> roles = principal.getAuthorities()
                    .stream()
                    .map(a -> a.getAuthority())
                    .collect(java.util.stream.Collectors.toSet());

            // Access/Refresh Token 생성
            String accessToken = jwtProvider.generateAccessToken(loginId, roles);
            String refreshToken = jwtProvider.generateRefreshToken(loginId, roles);

            long accessExpiresIn = jwtProvider.getRemainingMillis(accessToken);
            long refreshRemaining = jwtProvider.getRemainingMillis(refreshToken);

            Instant refreshExpiry = Instant.now().plusMillis(refreshRemaining);

            User user = userRepository.findByLoginId(loginId)
                    .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

            refreshTokenRepository.findByUser(user)
                    .ifPresentOrElse(
                            r -> {
                                r.renew(refreshToken, refreshExpiry);
                                refreshTokenRepository.save(r);
                            },
                            () -> {
                                RefreshToken r = RefreshToken.builder()
                                        .user(user)
                                        .token(refreshToken)
                                        .expiry(refreshExpiry)
                                        .build();
                                refreshTokenRepository.save(r);
                            }
                    );

            CookieUtils.addHttpOnlyCookie(
                    response,
                    REFRESH_TOKEN,
                    refreshToken,
                    (int) (refreshRemaining / 1000),
                    true
            );

            return ResponseDto.success("로그인 성공", LoginResponseDto.of(accessToken, accessExpiresIn));

        } catch (BadCredentialsException ex) {
            throw new BusinessException(ErrorCode.AUTHENTICATION_FAILED);
        } catch (Exception ex) {
            throw new BusinessException(ErrorCode.INTERNAL_ERROR, ex.getMessage());
        }
    }

    // 로그아웃
    @Override
    public ResponseDto<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    // 아이디 찾기
    @Override
    public ResponseDto<FindIdResponseDto> findId(FindIdRequestDto request) {
        return null;
    }

    // 비밀번호 재설정
    @Override
    public ResponseDto<Void> resetPassword(PasswordResetRequest request) {
        return null;
    }

    // 리프레시 토큰
    @Override
    public ResponseDto<LoginResponseDto> refreshAccessToken(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    // 비밀번호 토큰
    @Override
    public ResponseDto<PasswordVerifyResponseDto> verifyPasswordToken(String token) {
        return null;
    }
}
