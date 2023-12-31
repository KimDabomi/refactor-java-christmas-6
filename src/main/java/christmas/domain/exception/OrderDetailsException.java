package christmas.domain.exception;

import java.util.Arrays;
import java.util.stream.IntStream;

public class OrderDetailsException extends IllegalArgumentException{
    public OrderDetailsException(String errorMessage) {
        super(errorMessage);
    }
    
    public static void checkDateType(String date) {
        CheckTypeOfNumber.checkTypeOfNumber(date, ErrorMessage.DATE_ERROR_MESSAGE);
    }

    public static void checkDateRange(int date) {
        IntStream.range(NumberOfException.MIN_DATE.getNumber(), NumberOfException.MAX_DATE.getNumber())
                .filter(i -> date < NumberOfException.MIN_DATE.getNumber() || date > NumberOfException.MAX_DATE.getNumber())
                .findAny()
                .ifPresent(i -> {
                    throw new OrderDetailsException((ErrorMessage.DATE_ERROR_MESSAGE.getErrorMessage()));
                });
    }

    public static void checkOrderType(String[] menuItems) {
        Arrays.stream(menuItems).forEach(menuItem -> {
            String[] details = menuItem.split("-");

            if (details.length != NumberOfException.ORDER_LIST_SIZE.getNumber()) {
                throw new OrderDetailsException(ErrorMessage.ORDER_NOT_VALID_ERROR_MESSAGE.getErrorMessage());
            }
        });
    }
}
