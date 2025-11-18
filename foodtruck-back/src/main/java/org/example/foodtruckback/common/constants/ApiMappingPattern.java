package org.example.foodtruckback.common.constants;

public class ApiMappingPattern {
    private ApiMappingPattern () {};

    public static final String API = "/api";
    public static final String V1 = "/v1";
    public static final String BASE = API + V1;

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

    // 주문 품목
    public static final class OrderItem {
        private OrderItem () {}

        public static final String ROOT = Order.ROOT + Order.BY_ID + "/order-items";

        public static final String BY_ID = "/{order-itemId}";
        // 주문 후 주문 품목에 대한 추가/수정/삭제
        public static final String MODIFY = ROOT + BY_ID;
    }

    // 결제
    public static final class Payment {
        private Payment () {}

        public static final String ROOT = Order.ROOT + Order.BY_ID + "/payments";
        public static final String BY_ID = "/{paymentId}";
        public static final String CAPTURE =  ROOT + BY_ID + "/capture";
    }

}
