import {
  type RoleCreateRequest,
  type RoleCreateResponse,
  type RoleListResponse,
} from "@/types/role/role.dto";
import { privateApi, publicApi } from "../common/axiosInstance";
import { ROLE_PATH } from "./role.path";
import type { ApiResponse } from "@/types/common/ApiResponse";
import { USER_PATH } from "../user/user.path";

export const roleApi = {
  // 권한 목록
  getroleList: async (): Promise<RoleListResponse> => {
    const res = await publicApi.get<ApiResponse<RoleListResponse>>(
      ROLE_PATH.LISt
    );

    return res.data.data;
  },

  // 권한 추가
  add: async (
    userId: number,
    req: RoleCreateRequest
  ): Promise<RoleCreateResponse> => {
    const res = await privateApi.post<ApiResponse<RoleCreateResponse>>(
      USER_PATH.ROLEADD(userId), req
    );

    return res.data.data;
  },

  // 권한 제거
  delete: async (userId: number, roleName: string): Promise<void> => {
    const res = await privateApi.delete<ApiResponse<void>>(
      USER_PATH.ROLEDELETE(userId, roleName)
    );

    return res.data.data;
  }
};
