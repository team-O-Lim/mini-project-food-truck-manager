package org.example.foodtruckback.dto.reservation.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReservationCreateRequestDto(
        Long scheduleId,
        Long userId,
        LocalDateTime pickupTime,
        BigDecimal totalAmount,
        String note
){}
