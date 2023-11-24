package christmas.domain.exception;

import java.util.Optional;

public interface CheckTypeOfNumber {
    public static final String numberType = "[+-]?\\d*(\\.\\d+)?";

    public static void checkTypeOfNumber(String string, ErrorMessage errorMessage) {
        Optional.ofNullable(string)
                .filter(q -> q.matches(numberType))
                .orElseThrow(() -> new OrderItemException(errorMessage.getErrorMessage()));
    }
}
