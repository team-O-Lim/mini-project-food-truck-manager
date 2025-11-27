package org.example.foodtruckback.common.constants.schedule;

import org.example.foodtruckback.common.constants.ApiBase;

public class Schedule {
    private Schedule () {}

    public static final String ROOT = ApiBase.BASE + "/schedules";

    public static final String BY_ID = "/{scheduleId}";
}
