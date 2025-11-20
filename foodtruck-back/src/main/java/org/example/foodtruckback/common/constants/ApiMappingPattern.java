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
        public static final String BY_ID = "/{userId}";
    }

    private static class Roles {
        private Roles() {}

        public static final String ROOT = BASE + "/roles";

        public static final String ADD = "/add";
        public static final String DELETE = "/delete";
    }

    public static class Truck {
        private Truck () {};

        public static final String ROOT = BASE;

        public static final String COLLECTION = "/trucks";
        public static final String BY_ID = "/trucks/{truckId}";

        public static final String SCHEDULE_ROOT = BY_ID + "/schedules";
        public static final String SCHEDULE_BY_ID = SCHEDULE_ROOT + "/{scheduleId}";
    }

    public static class Menu {
        private Menu () {};

        public static final String ROOT = BASE;

        public static final String COLLECTION = Truck.BY_ID + "/menu";
        public static final String BY_ID = COLLECTION + "/{menuId}";
        public static final String IS_SOLD_OUT = BY_ID + "/sold-out";
    }

    public static class Reservation {
        private Reservation () {};

        public static final String ROOT = BASE + "/reservations";

        public static final String BY_ID = "/{reservationId}";
        public static final String CANCEL = BY_ID + "/cancel";
        public static final String CONFIRM = BY_ID + "/confirm";
        public static final String NO_SHOW = BY_ID + "/no-show";
    }

    // 주문
    public static final class Order {
        private Order () {}

        public static final String ROOT = BASE + "/orders";

        public static final String BY_ID = "/{orderId}";
        // cancel
        public static final String CANCEL = BY_ID + "/cancel";
        // refund
        public static final String REFUND = BY_ID + "/refund";
    }

    // 결제
    public static final class Payment {
        private Payment () {}

        public static final String ROOT = BASE+ "/payments";
        public static final String CAPTURE = Order.BY_ID + "/capture";
    }

}
