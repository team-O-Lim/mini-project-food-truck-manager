package org.example.foodtruckback.repository.schedule;

import org.example.foodtruckback.entity.truck.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
