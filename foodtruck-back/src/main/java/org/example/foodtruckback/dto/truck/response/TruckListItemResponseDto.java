package org.example.foodtruckback.dto.truck.response;

import org.example.foodtruckback.common.enums.TurckStatus;
import org.example.foodtruckback.entity.truck.Truck;

public record TruckListItemResponseDto(
        Long id,
        String name,
        String cuisine,
        TurckStatus status
) {
   public static TruckListItemResponseDto from(Truck truck) {
       return new TruckListItemResponseDto(
               truck.getId(),
               truck.getName(),
               truck.getCuisine(),
               truck.getStatus()
       );
   }
}
