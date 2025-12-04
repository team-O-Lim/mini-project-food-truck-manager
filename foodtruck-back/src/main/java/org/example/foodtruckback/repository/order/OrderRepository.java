package org.example.foodtruckback.repository.order;

import org.example.foodtruckback.dto.order.response.OwnerOrderListResponseDto;
import org.example.foodtruckback.dto.order.response.UserOrderListResponseDto;
import org.example.foodtruckback.entity.order.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<UserOrderListResponseDto> findByUserLoginId(String username);

    @Query("""
        SELECT new org.example.foodtruckback.dto.order.response.OwnerOrderListResponseDto(
            o.id,
            o.schedule.id,
            o.user.id,
            o.source,
            o.amount,
            o.currency,
            o.status,
            o.createdAt
            )
        FROM Order o
        WHERE o.schedule.truck.id = :truckId
    """)
    List<OwnerOrderListResponseDto> findByTruckId(@Param("truckId") Long truckId);

    @NonNull
    @EntityGraph(attributePaths = {"orderItems", "orderItems.menuItem", "user", "reservation"})
    Optional<Order> findById(@NonNull Long orderId);
}
