package org.example.foodtruckback.dto.schedule.response;

import org.example.foodtruckback.common.enums.ScheduleStatus;

import java.time.LocalDateTime;

public record ScheduleDetailResponseDto(
        Long id,
        Long truckId,
        Long locationId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        ScheduleStatus status,
        int maxReservations,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){}
