package org.example.foodtruckback.dto.schedule.request;

import java.time.LocalDateTime;

public record ScheduleCreateUpdateRequest(
        Long truckId,
        Long locationId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        int maxReservations
){}
