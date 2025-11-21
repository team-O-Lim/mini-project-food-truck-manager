package org.example.foodtruckback.dto.auth.response;

public record SignupResponseDto(
        String name,
        String loginId,
        String email,
        String phone
) {}
