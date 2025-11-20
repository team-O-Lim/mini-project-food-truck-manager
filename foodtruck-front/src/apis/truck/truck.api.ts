import type { TruckListResponse } from "@/types/truck/truck.dto";
import { publicApi } from "../common/axiosInstance";
import { TRUCK_PATH } from "./truck.path";
import type { ApiResponse } from "@/types/common/ApiResponse";

export const truckApi = {
  getTruckList: async (): Promise<TruckListResponse> => {
    const res = await publicApi.get<ApiResponse<TruckListResponse>>(TRUCK_PATH.LIST);
    return res.data.data;
  },

  createTruck: async () => {
    const res = await publicApi.post(TRUCK_PATH.CREATE);
    return res.data.data;
  },

  getTruckById: async (truckId: number) => {
    const res = await publicApi.get(TRUCK_PATH.BY_ID(truckId));
    return res.data.data;
  },

  getTruckMenu: async (truckId: number) => {
    const res = await publicApi.get(TRUCK_PATH.TRUCK_MENU(truckId));
    return res.data.data;
  },

  getScheduleList: async (truckId: number) => {
    const res = await publicApi.get(TRUCK_PATH.SCHEDULE_ROOT(truckId));
    return res.data.data;
  },

  getScheduleById: async (truckId: number, scheduleId: number) => {
    const res = await publicApi.get(
      TRUCK_PATH.SCHEDULE_BY_ID(truckId, scheduleId)
    );
    return res.data.data;
  },
}