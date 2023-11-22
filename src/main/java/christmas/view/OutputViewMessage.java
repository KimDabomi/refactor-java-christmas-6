package christmas.view;

public enum OutputViewMessage {
    SHOW_PREVIEW_EVENT_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    SHOW_ORDER_MENU_MESSAGE("\n<주문 메뉴>"),
    SHOW_BEFORE_DISCOUNT_AMOUNT_MESSAGE("<할인 전 총주문 금액>"),
    SHOW_GIFT_TITLE_MESSAGE("\n<증정 메뉴>"),
    SHOW_GIFT_MENU_MESSAGE("샴페인 1개"),
    SHOW_NONE_MESSAGE("없음"),
    SHOW_EVENT_LIST_TITLE_MESSAGE("\n<혜택 내역>"),
    SHOW_TOTAL_EVENT_TITLE_MESSAGE("\n<총혜택 금액>"),
    SHOW_FINAL_AMOUNT_MESSAGE("\n<할인 후 예상 결제 금액>"),
    SHOW_BADGE_MESSAGE("\n<12월 이벤트 배지>"),
    SHOW_CHRISTMAS_EVENT_MESSAGE("크리스마스 디데이 할인: -%s원"),
    SHOW_WEEKDAY_EVENT_MESSAGE("평일 할인: -%s원"),
    SHOW_WEEKEND_EVENT_MESSAGE("주말 할인: -%s원"),
    SHOW_SPECIAL_EVENT_MESSAGE("특별 할인: -%s원"),
    SHOW_GIFT_EVENT_MESSAGE("증정 이벤트: -%s원"),
    SHOW_MINUS_AMOUNT_MESSAGE("-%s원"),
    SHOW_INT_AMOUNT_MESSAGE("%d원"),
    SHOW_STRING_AMOUNT_MESSAGE("%s원"),
    NONE("0"),
    AMOUNT_FORMAT("###,###");

    private final String outputViewMessage;

    OutputViewMessage(String outputViewMessage) {
        this.outputViewMessage = outputViewMessage;
    }

    public String getOutputViewMessage() {
        return outputViewMessage;
    }
}
