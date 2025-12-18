package org.example.foodtruckback.dto.order.response;

import org.example.foodtruckback.common.enums.OrderSource;
import org.example.foodtruckback.common.enums.OrderStatus;
import org.example.foodtruckback.entity.order.Order;

import java.time.LocalDateTime;

public record OwnerOrderListResponseDto(
        Long id,
        Long scheduleId,
        Long userId,
        OrderSource source,
        int amount,
        String currency,
        OrderStatus status,
        LocalDateTime createdAt
) {
    public static OwnerOrderListResponseDto from(Order order) {
        return new OwnerOrderListResponseDto(
                order.getId(),
                order.getSchedule().getId(),
                order.getUser() != null ? order.getUser().getId() : null,
                order.getSource(),
                order.getAmount(),
                order.getCurrency(),
                order.getStatus(),
                order.getCreatedAt()
        );
    }
}
