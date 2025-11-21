package org.example.foodtruckback.dto.location.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LocationDetailResponseDto(
        Long id,
        String name,
        String address,
        BigDecimal latitude,
        BigDecimal longitude,
        LocalDateTime createdAt
) {
}
