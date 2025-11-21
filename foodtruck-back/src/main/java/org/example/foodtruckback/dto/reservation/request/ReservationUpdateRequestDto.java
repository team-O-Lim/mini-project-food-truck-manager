package org.example.foodtruckback.dto.reservation.request;

import java.math.BigDecimal;

public record ReservationUpdateRequestDto(
        String name,
        BigDecimal price,
        Boolean isSoldOut,
        String optionText
) {}
