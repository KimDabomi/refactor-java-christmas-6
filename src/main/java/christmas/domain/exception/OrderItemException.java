package christmas.domain.exception;

public class OrderItemException extends IllegalArgumentException {

    public OrderItemException(String errorMessage) {
        super(errorMessage);
    }

    public static void checkQuantityType(String quantity) {
        CheckTypeOfNumber.checkTypeOfNumber(quantity, ErrorMessage.ORDER_NOT_VALID_ERROR_MESSAGE);
    }
}
