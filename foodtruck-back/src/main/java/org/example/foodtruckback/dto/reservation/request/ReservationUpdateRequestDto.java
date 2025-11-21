package org.example.foodtruckback.dto.reservation.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import org.example.foodtruckback.common.enums.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReservationUpdateRequestDto(
        LocalDateTime pickupTime,

        @DecimalMin("0.0")
        BigDecimal totalAmount,

        ReservationStatus status,

        @Size(max = 255)
        String note
) {}
