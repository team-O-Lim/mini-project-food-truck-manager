import type {
  CreateOrderItem,
  OrderItem,
  OrderSource,
  OrderStatus,
  UpdateOrderItem,
} from "./order.type";

export interface OrderCreateRequest {
  scheduleId: number;
  userId?: number | null;
  source: OrderSource;
  reservationId?: number | null;
  items: CreateOrderItem[];
}

export interface OrderUpdateRequest {
  items: UpdateOrderItem[];
}

export interface OrderDetailResponse {
  id: number;
  scheduleId: number;
  userId: number | null;
  username: string | null;
  source: OrderSource;
  reservationId: number | null;
  amount: number;
  currency: "KRW";
  status: OrderStatus;

  paidAt: string | null;
  createdAt: string;
  updatedAt: string;

  items: OrderItem[];
}

export interface UserOrderListItemResponse {
  id: number;
  scheduleId: number;
  userId: number | null;
  amount: number;
  currency: "KRW";
  status: OrderStatus;
  createdAt: string;
}

export interface OwnerOrderListItemResponse {
  id: number;
  scheduleId: number;
  userId: number | null;
  source: OrderSource;
  amount: number;
  currency: "KRW";
  status: OrderStatus;
  createdAt: string;
}

export interface AdminOrderListItemResponse {
  id: number;
  scheduleId: number;
  userId: number | null;
  username: string | null;
  source: OrderSource;
  amount: number;
  currency: "KRW";
  status: OrderStatus;
  createdAt: string;
}

export type UserOrderListResponse = UserOrderListItemResponse[];
export type OwnerOrderListResponse = OwnerOrderListItemResponse[];
export type AdminOrderListResponse = AdminOrderListItemResponse[];
