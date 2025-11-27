package org.example.foodtruckback.common.constants.auth;

import org.example.foodtruckback.common.constants.ApiBase;

public class AuthApi {
    private AuthApi() {}

    public static final String ROOT = ApiBase.BASE + "/auths";

    public static final String SIGNUP = "/signup";
    public static final String LOGIN = "/login";
    public static final String LOGOUT = "/logout";
    public static final String REFRESH = "/refresh";
}
