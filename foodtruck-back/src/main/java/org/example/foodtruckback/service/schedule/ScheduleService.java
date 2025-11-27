package org.example.foodtruckback.service.schedule;

import jakarta.validation.Valid;
import org.example.foodtruckback.dto.ResponseDto;
import org.example.foodtruckback.dto.schedule.request.ScheduleCreateRequestDto;
import org.example.foodtruckback.dto.schedule.response.ScheduleDetailResponseDto;

public interface ScheduleService {
    ResponseDto<ScheduleDetailResponseDto> create(@Valid ScheduleCreateRequestDto request);
}
