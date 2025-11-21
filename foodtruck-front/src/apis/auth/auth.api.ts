import { privateApi, publicApi } from "../common/axiosInstance";
import type {
  LoginRequest,
  LoginResponse,
  RefreshRequest,
  RefreshResponse,
  SignupRequest,
  SignupResponse,
} from "@/types/auth/auth.dto";
import { AUTH_PATH } from "./auth.path";
import type { ApiResponse } from "@/types/common/ApiResponse";

export const authApi = {
  // 회원가입
  signup: async (req: SignupRequest): Promise<SignupResponse> => {
    const res = await publicApi.post<ApiResponse<SignupResponse>>(
      AUTH_PATH.SIGNUP, req
    );

    return res.data.data;
  },

  // 로그인
  login: async (req: LoginRequest): Promise<LoginResponse> => {
    const res = await publicApi.post<ApiResponse<LoginResponse>>(
      AUTH_PATH.LOGIN, req
    );

    return res.data.data;
  },

  // 로그아웃
  logout: async (): Promise<void> => {
    const res = await privateApi.post<ApiResponse<void>>(
      AUTH_PATH.LOGOUT
    );

    return res.data.data;
  },

  // 리프레시
  refresh: async (req: RefreshRequest): Promise<RefreshResponse> => {
    const res = await publicApi.post<ApiResponse<RefreshResponse>>(
      AUTH_PATH.REFRESH, req
    );
    
    return res.data.data;
  }
};
