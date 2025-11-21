import type { ApiResponse } from "@/types/common/ApiResponse";
import { privateApi, publicApi } from "../common/axiosInstance"
import { PAYMENT_PATH } from "./payment.path";
import type { PaymentApproveRequest, PaymentApproveResponse, PaymentCaptureResponse } from "@/types/payment/payment.dto";

export const paymentApi = {
  approvePayment: async (request: PaymentApproveRequest): Promise<PaymentApproveResponse> => {
    const res = await publicApi.post<ApiResponse<PaymentApproveResponse>>(
      PAYMENT_PATH.APPROVE, request
    );

    return res.data.data;
  },

  capturePayment: async (orderId: number): Promise<PaymentCaptureResponse> => {
    const res = await privateApi.post<ApiResponse<PaymentCaptureResponse>>(
      PAYMENT_PATH.CAPTURE(orderId)
    );

    return res.data.data;
  }
}