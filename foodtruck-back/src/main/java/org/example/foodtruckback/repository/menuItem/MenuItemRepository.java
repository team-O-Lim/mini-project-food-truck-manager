package org.example.foodtruckback.repository.menuItem;

import org.example.foodtruckback.entity.truck.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
}
