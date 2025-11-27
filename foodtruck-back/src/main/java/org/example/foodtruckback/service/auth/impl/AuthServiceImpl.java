package org.example.foodtruckback.service.auth.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.foodtruckback.dto.ResponseDto;
import org.example.foodtruckback.dto.auth.request.FindIdRequestDto;
import org.example.foodtruckback.dto.auth.request.LoginRequestDto;
import org.example.foodtruckback.dto.auth.request.PasswordResetRequest;
import org.example.foodtruckback.dto.auth.request.SignupRequestDto;
import org.example.foodtruckback.dto.auth.response.FindIdResponseDto;
import org.example.foodtruckback.dto.auth.response.LoginResponseDto;
import org.example.foodtruckback.dto.auth.response.PasswordVerifyResponseDto;
import org.example.foodtruckback.dto.auth.response.SignupResponseDto;
import org.example.foodtruckback.service.auth.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {


    @Override
    public ResponseDto<SignupResponseDto> sign(SignupRequestDto request, HttpServletResponse response) {
        return null;
    }

    @Override
    public ResponseDto<LoginResponseDto> login(LoginRequestDto request, HttpServletResponse response) {
        return null;
    }

    @Override
    public ResponseDto<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public ResponseDto<FindIdResponseDto> findId(FindIdRequestDto request) {
        return null;
    }

    @Override
    public ResponseDto<Void> resetPassword(PasswordResetRequest request) {
        return null;
    }

    @Override
    public ResponseDto<LoginResponseDto> refreshAccessToken(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public ResponseDto<PasswordVerifyResponseDto> verifyPasswordToken(String token) {
        return null;
    }
}
