package christmas.view;

public enum InputViewMessage {
    START_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ASK_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ASK_ORDER_MENU_QUANTITY_MESSAGE("주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    SPLIT_CRITERIA(",");

    private final String inputViewMessage;

    InputViewMessage(String inputViewMessage) {
        this.inputViewMessage = inputViewMessage;
    }

    public String getInputViewMessage() {
        return inputViewMessage;
    }
}
