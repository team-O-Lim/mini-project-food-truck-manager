package org.example.foodtruckback.dto.truck.request;

import org.example.foodtruckback.common.enums.TurckStatus;

public record TruckUpdateRequestDto(
        String name,
        String cuisine,
        TurckStatus status
) {}
