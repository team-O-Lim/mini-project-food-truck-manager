import { BASE } from "../common/base.path";

const ROLE_PREFIX = `${BASE}/role`;

export const ROLE_PATH = {
  ROOT: ROLE_PREFIX,

  ADD : `${ROLE_PREFIX}/add`,
  DELETE: `${ROLE_PREFIX}/delete`
}


