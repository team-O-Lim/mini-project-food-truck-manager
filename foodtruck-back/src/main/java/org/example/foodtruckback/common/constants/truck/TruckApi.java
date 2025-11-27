package org.example.foodtruckback.common.constants.truck;

import org.example.foodtruckback.common.constants.ApiBase;

public class TruckApi {
    private TruckApi () {}

    public static final String ROOT = ApiBase.BASE + "/trucks";

    public static final String BY_ID = "/{truckId}";

    public static final String TRUCK_MENU = BY_ID + "/menu";
    public static final String SCHEDULE_ROOT = BY_ID + "/schedules";
    public static final String SCHEDULE_BY_ID = SCHEDULE_ROOT + "/{scheduleId}";
}
