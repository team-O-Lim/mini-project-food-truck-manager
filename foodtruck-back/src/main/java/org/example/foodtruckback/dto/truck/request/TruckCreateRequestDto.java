package org.example.foodtruckback.dto.truck.request;

public record TruckCreateRequestDto(
        Long ownerId,
        String name,
        String cuisine
){}