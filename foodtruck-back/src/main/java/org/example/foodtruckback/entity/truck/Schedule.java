package org.example.foodtruckback.entity.truck;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.foodtruckback.common.enums.ScheduleStatus;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "truck_schedules",
        indexes = {
                @Index(name = "idx_schedule_time", columnList = "start_time, end_time"),
                @Index(name = "idx_schedule_truck", columnList = "truck_id, status"),
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "truck_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_trucks_schedule"))
    private Truck truckId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_trucks_location"))
    private Location locationId;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ScheduleStatus status = ScheduleStatus.PLANNED;

    @Column(name = "max_reservations", nullable = false)
    private int maxReservations = 100;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
