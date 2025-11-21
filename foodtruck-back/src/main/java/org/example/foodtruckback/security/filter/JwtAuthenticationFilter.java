package org.example.foodtruckback.security.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodtruckback.security.provider.JwtProvider;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter {
    private final JwtProvider jwtProvider;
//    private final UserPrincipalMapper

}
