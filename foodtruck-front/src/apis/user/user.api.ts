import type {
  UserDetailResponse,
  UserDetailResquest,
  UserListResponse,
  UserResponse,
} from "@/types/user/user.dto";
import { privateApi, publicApi } from "../common/axiosInstance";
import { USER_PATH } from "./user.path";
import type { ApiResponse } from "@/types/common/ApiResponse";

export const userApi = {
  me: async (req: UserDetailResquest): Promise<UserDetailResponse> => {
    const res = await privateApi.get<ApiResponse<UserDetailResponse>>(
      USER_PATH.ME,
      req
    );
    return res.data.data;
  },

  userAll: async (): Promise<UserListResponse> => {
    const res = await publicApi.get<ApiResponse<UserListResponse>>(
      USER_PATH.ROOT
    );
    return res.data.data;
  },

  userById: async (userId: number): Promise<UserResponse> => {
    const res = await publicApi.get<ApiResponse<UserResponse>>(
      USER_PATH.BY_ID(userId)
    );
    return res.data.data;
  },
};
