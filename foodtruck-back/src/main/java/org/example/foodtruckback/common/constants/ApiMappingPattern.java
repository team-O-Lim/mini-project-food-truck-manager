package org.example.foodtruckback.common.constants;

public class ApiMappingPattern {
    private ApiMappingPattern () {};

    public static final String API = "/api";
    public static final String V1 = "/v1";
    public static final String BASE = API + V1;

    public static class Auths {
        private Auths() {}

        public static final String ROOT = BASE + "/auths";
        public static final String SIGNUP = "/signup";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String REFRESH = "/refresh";
    }

    private static class Users {
        private Users() {}

        public static final String ROOT = BASE + "/users";
        public static final String ME = "/me";
        public static final String BY_ID = "/userId";
    }

    private static class Roles {
        private Roles() {}

        public static final String ROOT = BASE + "/roles";
        public static final String ADD = "/add";
        public static final String DELETE = "/delete";
    }


}
