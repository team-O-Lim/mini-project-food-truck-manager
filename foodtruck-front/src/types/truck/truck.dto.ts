import type { TruckStatus } from "./truck.type";

export interface TruckCreateRequest {
  name: string;
  cuisine?: string;
}

export interface TruckDetailResponse {
  id: number;
  ownerId: number;
  name: string;
  cuisine?: string;
  status: TruckStatus;
  createdAt: string;
  updatedAt: string;

  schedules: TruckScheduleItemResponse[];
}

export interface TruckListItemResponse {
  id: number;
  name: string;
  cuisine?: string;
  status: TruckStatus;
}

export interface TruckUpdateRequest {
  name?: string;
  cuisine?: string;
  status?: TruckStatus;
}

export type TruckListResponse = TruckListItemResponse[];
export interface TruckMenuItemResponse {
  id: number;
  name: string;
  price: number;
  description?: string;
  imageUrl?: string;
  soldOut: boolean;
}

export type TruckMenuListResponse = TruckMenuItemResponse[];


export interface TruckScheduleItemResponse {
  id: number;
  startTime: string;
  endTime: string;
  location: string;
  status: TruckStatus;
}

export interface ScheduleCreateRequest {
  startTime: string;
  endTime: string;
  location: string;
}
export interface ScheduleUpdateRequest {
  startTime?: string;
  endTime?: string;
  location?: string;
  status?: TruckStatus;
}

