package org.example.foodtruckback.dto.auth.response;

import java.util.Set;

public record LoginResponseDto(
        String accessToken,
        String refreshToken,
        long accessTokenExpiresInMillis
) {
    public static LoginResponseDto of(String accessToken, String refreshToken, long accessTokenExpiresInMillis) {
        return new LoginResponseDto(
                accessToken,
                refreshToken,
                accessTokenExpiresInMillis
        );
    }
}
