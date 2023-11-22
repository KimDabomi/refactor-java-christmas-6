package christmas.domain.exception;

import java.util.Optional;

public class OrderItemException extends IllegalArgumentException {
    private static final String numberType = "[+-]?\\d*(\\.\\d+)?";

    public OrderItemException(String errorMessage) {
        super(errorMessage);
    }

    public static void checkQuantityType(String quantity) {
        Optional.ofNullable(quantity)
                .filter(q -> q.matches(numberType))
                .orElseThrow(() -> new OrderItemException(ErrorMessage.ORDER_NOT_VALID_ERROR_MESSAGE.getErrorMessage()));
    }
}
