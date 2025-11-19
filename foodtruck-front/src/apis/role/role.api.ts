import type { RoleCreateRequest, RoleCreateResponse, RoleResponse } from "@/types/role/role.dto";
import { ROLE_PATH } from "./role.path";
import type { ApiResponse } from "@/types/common/ApiResponse";
import { privateApi } from "../common/axiosInstance";

export const roleApi = {
  add: async (req: RoleCreateRequest): Promise<RoleCreateResponse> => {
    const res = await privateApi.
    post<ApiResponse<RoleCreateResponse>>(
      ROLE_PATH.ADD, req
    );
    
    return res.data.data;
  },

  delete: async (): Promise<RoleResponse> => {
    const res = await privateApi.delete<ApiResponse<RoleResponse>>(
      ROLE_PATH.DELETE
    );

    return res.data.data;
  }
}