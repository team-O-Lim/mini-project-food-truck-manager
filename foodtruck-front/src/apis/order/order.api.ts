import type { OrderListResponse } from "@/types/order/order.dto";
import { publicApi } from "../common/axiosInstance";
import type { ApiResponse } from "@/types/common/ApiResponse";
import { ORDER_PATH } from "./order.path";

export const orderApi = {
  getOrderList: async (): Promise<OrderListResponse> => {
    const res = await publicApi.get<ApiResponse<OrderListResponse>>(
      ORDER_PATH.LIST
    );

    return res.data.data;
  }
}