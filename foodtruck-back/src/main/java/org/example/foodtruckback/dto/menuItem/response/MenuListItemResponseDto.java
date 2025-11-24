package org.example.foodtruckback.dto.menuItem.response;

import org.example.foodtruckback.entity.truck.MenuItem;

public record MenuListItemResponseDto(
        Long id,
        String name,
        int price,
        boolean isSoldOut,
        String optionText
) {
    public static MenuListItemResponseDto from(MenuItem menuItem) {
        return new MenuListItemResponseDto(
                menuItem.getId(),
                menuItem.getName(),
                menuItem.getPrice(),
                menuItem.isSoldOut(),
                menuItem.getOptionText()
        );
    }
}
