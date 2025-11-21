package org.example.foodtruckback.dto.truck.response;

import org.example.foodtruckback.common.enums.TurckStatus;

import java.time.LocalDateTime;

public record TruckDetailResponseDto(
        Long id,
        Long ownerId,
        String name,
        String cuisine,
        TurckStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
