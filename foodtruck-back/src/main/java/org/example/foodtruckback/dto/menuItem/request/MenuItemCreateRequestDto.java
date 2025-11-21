package org.example.foodtruckback.dto.menuItem.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MenuItemCreateRequestDto(
        Long scheduleId,
        Long userId,
        LocalDateTime pickupTime,
        BigDecimal totalAmount,
        String note
){}
