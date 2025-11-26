package org.example.foodtruckback.dto.user.request;

public record UserUpdateRequestDto(
        String name,
        String loginId,
        String email,
        String phone
) {
}
