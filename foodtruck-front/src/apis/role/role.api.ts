import { type RoleCreateRequest, type RoledeleteResponse, type RoleListResponse } from "@/types/role/role.dto";
import { privateApi, publicApi } from "../common/axiosInstance";
import { ROLE_PATH } from "./role.path";
import type { ApiResponse } from "@/types/common/ApiResponse";
import { USER_PATH } from "../user/user.path";


export const roleApi = {
  // 권한 목록
  getroleList: async(): Promise<RoleListResponse> => {
    const res = await publicApi.
    get<ApiResponse<RoleListResponse>>(
      ROLE_PATH.ROOT
    );

    return res.data.data;
  },

  // 권한 추가
  add: async (userId: number): Promise<RoleCreateRequest> => {
    const res = await privateApi.
    post<ApiResponse<RoleCreateRequest>>(
      USER_PATH.BY_ID(userId)
    )

    return res.data.data;
  },

  // 권한 제거
  delete: async (userId: number, roleName: string): Promise<RoledeleteResponse> => {
    const res = await privateApi.
    delete<ApiResponse<RoledeleteResponse>>(
      USER_PATH.DELETE(userId, roleName)
    )

    return res.data.data;
  } 
}