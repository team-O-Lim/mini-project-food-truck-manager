package org.example.foodtruckback.security.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodtruckback.entity.user.User;
import org.example.foodtruckback.repository.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserPrincipalMapper userPrincipalMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username == null || username.trim().isEmpty()) {
            throw new UsernameNotFoundException("Invalid username");
        }

        String loginId = username.trim();


        User user = userRepository.findByName(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));

        return userPrincipalMapper.map(user);
    }
}
