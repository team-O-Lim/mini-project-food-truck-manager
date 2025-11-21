package org.example.foodtruckback.dto.order.request;

import jakarta.validation.constraints.NotNull;
import org.example.foodtruckback.common.enums.OrderSource;
import org.example.foodtruckback.dto.orderItem.request.CreateOrderItemRequestDto;
import org.example.foodtruckback.entity.User;

import java.util.List;

public record OrderCreateRequestDto(
        @NotNull
        Schedule scheduleId,
        User userId,
        @NotNull
        OrderSource source,
        Reservation reservationId,
        @NotNull
        List<CreateOrderItemRequestDto> items
) {
}
