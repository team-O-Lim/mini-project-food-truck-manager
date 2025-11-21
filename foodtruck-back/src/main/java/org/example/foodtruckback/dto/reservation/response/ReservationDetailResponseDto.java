package org.example.foodtruckback.dto.reservation.response;

import org.example.foodtruckback.common.enums.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReservationDetailResponseDto(
        Long id,
        Long scheduleId,
        Long userId,
        LocalDateTime pickupTime,
        BigDecimal totalAmount,
        ReservationStatus status,
        String note,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){}
