package org.example.foodtruckback.service.order.impl;

import lombok.RequiredArgsConstructor;
import org.example.foodtruckback.common.enums.ErrorCode;
import org.example.foodtruckback.common.enums.OrderSource;
import org.example.foodtruckback.common.enums.OrderStatus;
import org.example.foodtruckback.dto.ResponseDto;
import org.example.foodtruckback.dto.order.request.OrderCreateRequestDto;
import org.example.foodtruckback.dto.order.request.OrderUpdateRequestDto;
import org.example.foodtruckback.dto.order.response.AdminOrderListResponseDto;
import org.example.foodtruckback.dto.order.response.OrderDetailResponseDto;
import org.example.foodtruckback.dto.order.response.OwnerOrderListResponseDto;
import org.example.foodtruckback.dto.order.response.UserOrderListResponseDto;
import org.example.foodtruckback.dto.orderItem.request.CreateOrderItemRequestDto;
import org.example.foodtruckback.dto.orderItem.request.UpdateOrderItemRequestDto;
import org.example.foodtruckback.entity.order.Order;
import org.example.foodtruckback.entity.order.OrderItem;
import org.example.foodtruckback.entity.reservation.Reservation;
import org.example.foodtruckback.entity.truck.MenuItem;
import org.example.foodtruckback.entity.truck.Schedule;
import org.example.foodtruckback.entity.user.User;
import org.example.foodtruckback.exception.BusinessException;
import org.example.foodtruckback.repository.menuItem.MenuItemRepository;
import org.example.foodtruckback.repository.order.OrderRepository;
import org.example.foodtruckback.repository.reservation.ReservationRepository;
import org.example.foodtruckback.repository.schedule.ScheduleRepository;
import org.example.foodtruckback.security.user.UserPrincipal;
import org.example.foodtruckback.service.order.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ScheduleRepository scheduleRepository;
    private final MenuItemRepository menuItemRepository;
    private final ReservationRepository reservationRepository;

    @Override
    @Transactional
    @PreAuthorize("hasRole('OWNER')")
    public ResponseDto<OrderDetailResponseDto> createOrder(
            OrderCreateRequestDto request, UserPrincipal principal
    ) {
        User user = null;
        Reservation reservation = null;

        Schedule schedule = scheduleRepository.findById(request.scheduleId())
                .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND)); // 스케쥴 에러코드 추가

        if(request.source() == OrderSource.RESERVATION) {
            if(request.reservationId() == null) {
                throw new BusinessException(ErrorCode.INVALID_INPUT);
            }

            reservation = reservationRepository.findById(request.reservationId())
                    .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));// reservation 에러 코드 추가

            if(!reservation.getSchedule().getId().equals(schedule.getId())) {
                throw new BusinessException(ErrorCode.INVALID_INPUT);
            }

            user = reservation.getUser();
        }

        int totalAmount = 0;
        List<OrderItem> orderItems = new ArrayList<>();

        for(CreateOrderItemRequestDto item : request.items()) {
            if(item.qty() <= 0) {
                throw new BusinessException(ErrorCode.INVALID_INPUT);
            }

            MenuItem menuItem = menuItemRepository.findById(item.menuItemId())
                    .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));

            if(menuItem.isSoldOut()) {
                throw new BusinessException(ErrorCode.INVALID_INPUT);
            }

            OrderItem orderItem = OrderItem.builder()
                    .menuItem(menuItem)
                    .qty(item.qty())
                    .price(menuItem.getPrice())
                    .build();

            orderItems.add(orderItem);
            totalAmount += menuItem.getPrice() * item.qty();
        }

        Order order = Order.builder()
                .schedule(schedule)
                .user(user)
                .source(request.source())
                .reservation(reservation)
                .status(OrderStatus.PENDING)
                .amount(totalAmount)
                .orderItems(orderItems)
                .build();

        orderItems.forEach(oi -> oi.setOrder(order));

        Order saved = orderRepository.save(order);

        OrderDetailResponseDto response = OrderDetailResponseDto.from(saved);
        return ResponseDto.success("주문 생성 완료", response);
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public ResponseDto<List<UserOrderListResponseDto>> getMyOrders(UserPrincipal principal) {
        List<UserOrderListResponseDto> response = orderRepository.findByUserLoginId(principal.getUsername());

        if(response == null) {
            response = List.of();
        }

        return ResponseDto.success("주문 조회 완료", response);
    }

    @Override
    @PreAuthorize("@ownerOrderAuthz.canChangeOrder(#truckId, authentication)")
    public ResponseDto<List<OwnerOrderListResponseDto>> getTruckOrders(
            Long truckId, UserPrincipal principal
    ) {
        List<OwnerOrderListResponseDto> response = orderRepository.findByTruckId(truckId);

        if(response == null) {
            response = List.of();
        }

        return ResponseDto.success("주문 조회 완료", response);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseDto<List<AdminOrderListResponseDto>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        List<AdminOrderListResponseDto> response = orders.stream()
                .map(AdminOrderListResponseDto::from)
                .toList();

        return ResponseDto.success("주문 조회 완료", response);
    }


    @Override
    @Transactional
    @PreAuthorize(
            "hasRole('ADMIN') " +
            "or @ownerOrderAuthz.canChangeOrder(#orderId, authentication) " +
            "or @userOrderAuthz.canChangeOrder(#orderId, authentication)"
    )
    public ResponseDto<OrderDetailResponseDto> updateOrder(
            Long orderId, OrderUpdateRequestDto request
    ) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));

        if(order.getStatus() != OrderStatus.PENDING) {
            throw new BusinessException(ErrorCode.INVALID_TYPE);
        }

        int totalAmount = 0;
        List<OrderItem> updatedItems = new ArrayList<>();

        for(UpdateOrderItemRequestDto item: request.items()) {
            MenuItem menuItem = menuItemRepository.findById(item.menuItemId())
                    .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));

            if(menuItem.isSoldOut()) {
                throw new BusinessException(ErrorCode.INVALID_INPUT);
            }

            if(item.qty() <= 0) {
                throw new BusinessException(ErrorCode.INVALID_INPUT);
            }

            OrderItem orderItem = OrderItem.builder()
                    .menuItem(menuItem)
                    .qty(item.qty())
                    .price(menuItem.getPrice())
                    .build();
            orderItem.setOrder(order);

            updatedItems.add(orderItem);
            totalAmount += menuItem.getPrice() * item.qty();
        }

        order.getOrderItems().clear();
        order.getOrderItems().addAll(updatedItems);
        order.setAmount(totalAmount);

        orderRepository.save(order);
        OrderDetailResponseDto response = OrderDetailResponseDto.from(order);

        return ResponseDto.success("주문 수정 완료", response);
    }

    @Override
    @PreAuthorize(
            "hasRole('ADMIN') " +
                    "or @ownerOrderAuthz.canChangeOrder(#orderId, authentication)" +
                    "or @userOrderAuthz.canChangeOrder(#orderId, authentication)"
    )
    public ResponseDto<OrderDetailResponseDto> getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));

        OrderDetailResponseDto response = OrderDetailResponseDto.from(order);

        return ResponseDto.success("주문 상세 조회 완료", response);
    }

    @Override
    @Transactional
    @PreAuthorize(
            "hasRole('ADMIN') " +
                    "or @ownerOrderAuthz.canChangeOrder(#orderId, authentication)" +
                    "or @userOrderAuthz.canChangeOrder(#orderId, authentication)"
    )
    public ResponseDto<Void> cancelOrder(Long orderId, UserPrincipal principal) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));

        if(order.getStatus() != OrderStatus.PENDING && order.getStatus() != OrderStatus.PAID) {
            throw new BusinessException(ErrorCode.INVALID_INPUT);
        }

        order.setStatus(OrderStatus.FAILED);
        orderRepository.save(order);

        return ResponseDto.success("주문 취소 완료", null);
    }

    @Override
    @Transactional
    @PreAuthorize(
            "hasRole('ADMIN') " +
                    "or @ownerOrderAuthz.canChangeOrder(#orderId, authentication)"
    )
    public ResponseDto<Void> refundOrder(Long orderId, UserPrincipal principal) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));

        if(order.getStatus() != OrderStatus.PAID) {
            throw new BusinessException(ErrorCode.INVALID_INPUT);
        }

        order.setStatus(OrderStatus.REFUNDED);
        orderRepository.save(order);

        return ResponseDto.success("주문 환불 완료", null);
    }

}
