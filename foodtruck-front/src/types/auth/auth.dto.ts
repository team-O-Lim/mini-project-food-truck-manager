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
  loginId: string;
  password: string;
}

export interface RefreshRequest {}

export interface RefreshResponse {}
