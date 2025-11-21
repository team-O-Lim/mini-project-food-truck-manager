package org.example.foodtruckback.dto.auth.request;

public record PasswordVerifyResponseDto(
        boolean valid,
        String email
) {
    public static PasswordVerifyResponseDto success(String e)
}
