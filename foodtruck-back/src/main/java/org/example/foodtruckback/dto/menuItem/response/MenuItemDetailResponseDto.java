package org.example.foodtruckback.dto.menuItem.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MenuItemDetailResponseDto(
        Long id,
        Long truckId,
        String name,
        BigDecimal price,
        boolean isSoldOut,
        String optionText,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){}
