export interface RoleNameResponse {
  roleName: string;
}

export type RoleListResponse = RoleNameResponse[];

export interface RoleCreateRequest {
  roleName: string;
}

export interface RoleCreateResponse {
  roleName: string;
}
