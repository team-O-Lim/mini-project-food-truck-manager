package org.example.foodtruckback.dto.menuItem.request;

import org.example.foodtruckback.common.enums.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MenuItemUpdateRequestDto(
        LocalDateTime pickupTime,
        BigDecimal totalAmount,
        ReservationStatus status,
        String note
){}
