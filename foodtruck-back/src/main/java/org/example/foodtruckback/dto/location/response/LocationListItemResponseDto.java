package org.example.foodtruckback.dto.location.response;

import java.time.LocalDateTime;

public record LocationListItemResponseDto(
    Long id,
    String name,
    String address,
    LocalDateTime createdAt
) {
}
