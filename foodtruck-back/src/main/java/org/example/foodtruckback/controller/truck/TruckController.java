package org.example.foodtruckback.controller.truck;

import lombok.RequiredArgsConstructor;
import org.example.foodtruckback.common.constants.truck.TruckApi;
import org.springframework.web.bind.annotation.RestController;

@RestController(TruckApi.ROOT)
@RequiredArgsConstructor
public class truckController {
    private final TruckService truckService;

}