package org.example.foodtruckback.controller.schedule;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.foodtruckback.common.constants.schedule.Schedule;
import org.example.foodtruckback.dto.ResponseDto;
import org.example.foodtruckback.dto.schedule.request.ScheduleCreateRequestDto;
import org.example.foodtruckback.dto.schedule.response.ScheduleDetailResponseDto;
import org.example.foodtruckback.service.schedule.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(Schedule.ROOT)
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // 생성
    @PostMapping
    public ResponseEntity<ResponseDto<ScheduleDetailResponseDto>> create(
            @Valid @RequestBody ScheduleCreateRequestDto request
    ) {
        ResponseDto<ScheduleDetailResponseDto> result = scheduleService.create(request);

        return ResponseEntity.ok().body(result);
    }
}
