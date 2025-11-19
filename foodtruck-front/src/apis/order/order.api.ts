import type { OrderDetailResponse, OrderListResponse } from "@/types/order/order.dto";
import { privateApi, publicApi } from "../common/axiosInstance";
import type { ApiResponse } from "@/types/common/ApiResponse";
import { ORDER_PATH } from "./order.path";

export const orderApi = {
  // 주문 목록 조회
  getOrderList: async (): Promise<OrderListResponse> => {
    const res = await privateApi.get<ApiResponse<OrderListResponse>> (
      ORDER_PATH.LIST
    );

    return res.data.data;
  },

  // 주문 상세 조회
  getOrder: async (orderId: number): Promise<OrderDetailResponse> => {
    const res = await privateApi.get<ApiResponse<OrderDetailResponse>> (
      ORDER_PATH.BY_ID(orderId)
    );

    return res.data.data
  },

  // 주문 취소
  cancelOrder: async (orderId: number): Promise<void> => {
    const res = await privateApi.put<ApiResponse<void>> (
      ORDER_PATH.CANCEL(orderId)
    );
  },

  // 환불 
  refundOrder: async (orderId: number): Promise<void> => {
    const res = await privateApi.put<ApiResponse<void>> (
      ORDER_PATH.REFUND(orderId)
    );
  }
}