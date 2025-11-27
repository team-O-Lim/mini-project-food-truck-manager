package org.example.foodtruckback.dto.truck.response;

import org.example.foodtruckback.common.enums.TurckStatus;
import org.example.foodtruckback.dto.menuItem.response.MenuItemDetailResponseDto;
import org.example.foodtruckback.dto.schedule.response.ScheduleItemResponseDto;
import org.example.foodtruckback.entity.truck.Truck;

import java.time.LocalDateTime;
import java.util.List;

public record TruckDetailResponseDto(
        Long id,
        Long ownerId,
        String name,
        String cuisine,
        TurckStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<ScheduleItemResponseDto> schedules,
        List<MenuItemDetailResponseDto> menu
) {
    public static TruckDetailResponseDto from(
            Truck truck, List<ScheduleItemResponseDto> schedules, List<MenuItemDetailResponseDto> menu
    ) {
        return new TruckDetailResponseDto(
                truck.getId(),
                truck.getOwner().getId(),
                truck.getName(),
                truck.getCuisine(),
                truck.getStatus(),
                truck.getCreatedAt(),
                truck.getUpdatedAt(),
                schedules,
                menu
        );
    }
}
