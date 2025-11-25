package org.example.foodtruckback.repository.reservation;

import org.example.foodtruckback.entity.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
