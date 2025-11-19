import type { 
  TruckCreateRequest,
  TruckListResponse, 
  TruckDetailResponse,
  TruckMenuListResponse,
  TruckMenuItemResponse,
  TruckMenuCreateRequest,
  TruckMenuUpdateRequest
} from "@/types/truck/truck.dto";

import { publicApi } from "../common/axiosInstance";
import { TRUCK_PATH, MENU_PATH } from "./truck.path";
import type { ApiResponse } from "@/types/common/ApiResponse";

export const truckApi = {
  // 트럭 목록 조회
  getTruckList: async (): Promise<TruckListResponse> => {
    const res = await publicApi.get<ApiResponse<TruckListResponse>>(TRUCK_PATH.LIST);
    return res.data.data;
  },

  // 트럭 생성
  createTruck: async (body: TruckCreateRequest): Promise<TruckDetailResponse> => {
    const res = await publicApi.post<ApiResponse<TruckDetailResponse>>(TRUCK_PATH.CREATE, body);
    return res.data.data;
  },

  // 트럭 상세 조회
  getTruckById: async (truckId: number): Promise<TruckDetailResponse> => {
    const res = await publicApi.get<ApiResponse<TruckDetailResponse>>(TRUCK_PATH.BY_ID(truckId));
    return res.data.data;
  },

  // 트럭 메뉴 목록 조회
  getTruckMenu: async (truckId: number): Promise<TruckMenuListResponse> => {
    const res = await publicApi.get<ApiResponse<TruckMenuListResponse>>(
      TRUCK_PATH.TRUCK_MENU(truckId)
    );
    return res.data.data;
  },

  // 트럭 메뉴 생성 (트럭 기준)
  createTruckMenu: async (
    truckId: number, 
    body: TruckMenuCreateRequest
  ): Promise<TruckMenuItemResponse> => {
    const res = await publicApi.post<ApiResponse<TruckMenuItemResponse>>(
      TRUCK_PATH.CREATE_MENU(truckId),
      body
    );
    return res.data.data;
  },

  // 메뉴 수정 (메뉴 엔티티 기준)
  updateMenu: async (
    menuId: number,
    body: TruckMenuUpdateRequest
  ): Promise<TruckMenuItemResponse> => {
    const res = await publicApi.put<ApiResponse<TruckMenuItemResponse>>(
      MENU_PATH.BY_ID(menuId),
      body
    );
    return res.data.data;
  },

  // 메뉴 삭제
  deleteMenu: async (menuId: number): Promise<void> => {
    await publicApi.delete(MENU_PATH.BY_ID(menuId));
  },

  // 메뉴 품절 상태 변경
  toggleSoldOutMenu: async (menuId: number): Promise<TruckMenuItemResponse> => {
    const res = await publicApi.patch<ApiResponse<TruckMenuItemResponse>>(
      MENU_PATH.SOLD_OUT(menuId)
    );
    return res.data.data;
  },

  // 스케줄 목록 조회
  getScheduleList: async (truckId: number) => {
    const res = await publicApi.get(TRUCK_PATH.SCHEDULE_ROOT(truckId));
    return res.data.data;
  },

  // 스케줄 상세 조회
  getScheduleById: async (truckId: number, scheduleId: number) => {
    const res = await publicApi.get(
      TRUCK_PATH.SCHEDULE_BY_ID(truckId, scheduleId)
    );
    return res.data.data;
  },
};
