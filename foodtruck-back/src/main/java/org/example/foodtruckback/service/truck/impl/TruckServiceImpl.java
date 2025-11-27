package org.example.foodtruckback.service.truck.impl;

import org.example.foodtruckback.dto.ResponseDto;
import org.example.foodtruckback.dto.truck.request.TruckCreateRequestDto;
import org.example.foodtruckback.dto.truck.request.TruckUpdateRequestDto;
import org.example.foodtruckback.dto.truck.response.TruckDetailResponseDto;
import org.example.foodtruckback.dto.truck.response.TruckListItemResponseDto;
import org.example.foodtruckback.service.truck.TruckService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {
    @Override
    public ResponseDto<TruckDetailResponseDto> createTruck(TruckCreateRequestDto request) {
        return null;
    }

    @Override
    public ResponseDto<TruckDetailResponseDto> getTruck(Long truckId) {
        return null;
    }

    @Override
    public ResponseDto<TruckDetailResponseDto> updateTruck(Long truckId, TruckUpdateRequestDto request) {
        return null;
    }

    @Override
    public ResponseDto<?> deleteTruck(Long truckId) {
        return null;
    }

    @Override
    public ResponseDto<List<TruckListItemResponseDto>> getAllTrucks() {
        return null;
    }
}
