package org.example.foodtruckback.repository.menuItem;

import org.example.foodtruckback.entity.truck.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
    Collection<MenuItem> findByTruckId(Long truckId);
}
