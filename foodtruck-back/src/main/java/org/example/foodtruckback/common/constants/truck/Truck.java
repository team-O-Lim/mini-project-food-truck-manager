package org.example.foodtruckback.common.constants.truck;

import org.example.foodtruckback.common.constants.ApiBase;

public class Truck {
    private Truck () {}

    public static final String ROOT = ApiBase.BASE + "/trucks";

    public static final String BY_ID = "/{truckId}";

    public static final String TRUCK_MENU = BY_ID + "/menu";
}
