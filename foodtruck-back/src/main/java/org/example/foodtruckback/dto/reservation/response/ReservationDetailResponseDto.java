package org.example.foodtruckback.dto.reservation.response;

import org.example.foodtruckback.common.enums.ReservationStatus;
import org.example.foodtruckback.entity.reservation.Reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReservationDetailResponseDto(
        Long id,
        Long scheduleId,
        Long userId,
        LocalDateTime pickupTime,
        int totalAmount,
        ReservationStatus status,
        String note,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){
    public static  ReservationDetailResponseDto from(Reservation reservation) {
        return new ReservationDetailResponseDto(
                reservation.getId(),
                reservation.getSchedule().getId(),
                reservation.getUser().getId(),
                reservation.getPickupTime(),
                reservation.getTotalAmount(),
                reservation.getStatus(),
                reservation.getNote(),
                reservation.getCreatedAt(),
                reservation.getUpdatedAt()
        );
    }
}
