package org.example.foodtruckback.service.schedule.impl;

import lombok.RequiredArgsConstructor;
import org.example.foodtruckback.dto.ResponseDto;
import org.example.foodtruckback.dto.schedule.request.ScheduleCreateRequestDto;
import org.example.foodtruckback.dto.schedule.response.ScheduleDetailResponseDto;
import org.example.foodtruckback.service.schedule.ScheduleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleServiceImpl implements ScheduleService {

    @Override
    public ResponseDto<ScheduleDetailResponseDto> create(ScheduleCreateRequestDto request) {
        return null;
    }
}
