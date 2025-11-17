package org.example.foodtruckback.common.constants;

public class ApiMappingPattern {
    private ApiMappingPattern () {};

    public static final String API = "/api";
    public static final String V1 = "/v1";
    public static final String BASE = API + V1;

    public static class Truck {
        private Truck () {};

        public static final String ROOT = BASE;

        public static final String COLLECTION = "/trucks";

        public static final String BY_ID = "/trucks/{truckId}";

    }

    public static class Menu {
        private Menu () {};

        public static final String ROOT = BASE;

        // 해당 트럭에 (메뉴 생성/ 전체 메뉴 조회)
        public static final String COLLECTION = Truck.BY_ID + "/menu";

        // 단건/ 수정/ 삭제
        public static final String BY_ID = COLLECTION + "/{menuId}";

        public static final String IS_SOLD_OUT = BY_ID + "/sold-out";
    }

    public static class Reservation {
        private Reservation () {};

        public static final String ROOT = BASE + "/reservations";
        public static final String BY_ID = "/{reservationId}";

        public static final String CANCEL = "/{reservationId}/cancel";
        public static final String CONFIRM = "/{reservationId}/confirm";
        public static final String NO_SHOW = "/{reservationId}/no-show";

    }

}
