import { BASE } from "../common/base.path";

const USER_PREFIX =`${BASE}/user`;

export const USER_PATH = {
  ROOT: USER_PREFIX,

  ME: `${USER_PREFIX}/me`,
  BY_ID: (userId: number) => `${USER_PREFIX}/${userId}`
  
}