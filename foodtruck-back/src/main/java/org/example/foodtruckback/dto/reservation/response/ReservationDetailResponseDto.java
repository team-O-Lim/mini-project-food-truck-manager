package org.example.foodtruckback.dto.reservation.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReservationDetailResponseDto(
        Long id,
        Long truckId,
        String name,
        BigDecimal price,
        boolean isSoldOut,
        String optionText,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){}
