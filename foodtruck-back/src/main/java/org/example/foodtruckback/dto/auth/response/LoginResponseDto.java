package org.example.foodtruckback.dto.auth.response;

import java.util.Set;

public record LoginResponseDto(
        String tokenType,
        String accessToken,
        long expiresAt,
        String userName,
        Set<String> roles
) {}
