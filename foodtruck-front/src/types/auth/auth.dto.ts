import type { RoleType } from "../role/role.type";

export interface SignupRequest {
  name: string;
  loginId: string;
  password: string;
  email: string;
  phone: string;
}

export interface SignupResponse {
  name: string;
  loginId: string;
  email: string;
  phone: string;
}

export interface LoginRequest {
  loginId: string;
  password: string;
}

export interface LoginResponse {
  tokenType: string,
  accessToken: string,
  expiresAt: number,
  userNmae: string,
  roles : RoleType[]
}

export interface FindIdRequest {
  email: string
}

export interface FindIdResponse {
  LoginId: string;
}

export interface ResetPWRequest {
  loginId: string,
  message: string,
  password: string,
  confirmPasswrod: string
}

export interface ResetPWResponse {
  loginId: string,
}


export interface RefreshRequest {}

export interface RefreshResponse {}
