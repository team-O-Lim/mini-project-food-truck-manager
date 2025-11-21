import type {
  UserDetailResponse,
  UserListResponse,
  UserUpdateRequest,
  UserUpdateResponse,
} from "@/types/user/user.dto";
import { privateApi, publicApi } from "../common/axiosInstance";
import { USER_PATH } from "./user.path";
import type { ApiResponse } from "@/types/common/ApiResponse";

export const userApi = {
  // 마이 프로필
  me: async (): Promise<UserDetailResponse> => {
    const res = await privateApi.get<ApiResponse<UserDetailResponse>>(
      USER_PATH.ME
    );
    
    return res.data.data;
  },

  // 내 정보 수정
  updateMe: async (req: UserUpdateRequest) => {
    const res = await privateApi.put<ApiResponse<UserUpdateResponse>>(
      USER_PATH.UPDATE, req
    );

    return res.data.data;
  },

  // 전체
  getUserList: async (): Promise<UserListResponse> => {
    const res = await privateApi.get<ApiResponse<UserListResponse>>(
      USER_PATH.LIST
    );

    return res.data.data;
  },

  // 단건
  getUser: async (userId: number): Promise<UserDetailResponse> => {
    const res = await privateApi.get<ApiResponse<UserDetailResponse>>(
      USER_PATH.BYID(userId)
    );

    return res.data.data;
  },

  // 사용자 수정
  updateUser: async (req: UserUpdateRequest, userId: number) => {
    const res = await privateApi.put<ApiResponse<UserUpdateResponse>>(
      USER_PATH.USERUPDATE(userId), req
    );

    return res.data.data;
  }
};
