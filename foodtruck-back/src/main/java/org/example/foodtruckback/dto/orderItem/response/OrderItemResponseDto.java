package org.example.foodtruckback.dto.orderItem.response;

import org.example.foodtruckback.entity.order.OrderItem;

public record OrderItemResponseDto(
        Long menuItemId,
        String menuItemName,
        int qty,
        int unitPrice
) {
    public static OrderItemResponseDto from(OrderItem item) {
        return new OrderItemResponseDto(
                item.getMenuItem().getId(),
                item.getMenuItem().getName(),
                item.getQty(),
                item.getPrice()
        );
    }
}
