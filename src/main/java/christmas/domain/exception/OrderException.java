package christmas.domain.exception;

import christmas.domain.order.OrderItem;
import java.util.List;
import java.util.stream.IntStream;

public class OrderException extends IllegalArgumentException {

    public OrderException(String errorMessage) {
        super(errorMessage);
    }

    public static void checkOrderItemExceptions(List<OrderItem> orderItemList) {
        checkOnlyDrink(orderItemList);
        checkTotalQuantity(orderItemList);
        checkQuantityRange(orderItemList);
        checkDuplicationMenu(orderItemList);
    }

    private static void checkOnlyDrink(List<OrderItem> orderItemList) {
        orderItemList.stream()
                .filter(orderItem -> !"음료".equals(orderItem.getMenu().getCategory()))
                .findAny()
                .orElseThrow(() -> new OrderException(ErrorMessage.ORDER_NOT_VALID_ERROR_MESSAGE.getErrorMessage()));
    }

    private static void checkTotalQuantity(List<OrderItem> orderItemList) {
        int totalQuantity = orderItemList.stream().mapToInt(OrderItem::getQuantity).sum();

        if (totalQuantity > NumberOfException.MAX_QUANTITY.getNumber()) {
            throw new OrderException(ErrorMessage.ORDER_NOT_VALID_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private static void checkQuantityRange(List<OrderItem> orderItemList) {
        int orderItemQuantity = orderItemList.stream().mapToInt(OrderItem::getQuantity).sum();

        if (orderItemQuantity < NumberOfException.MIN_QUANTITY.getNumber()) {
            throw new OrderException(ErrorMessage.ORDER_NOT_VALID_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private static void checkDuplicationMenu(List<OrderItem> orderItemList) {
        IntStream.range(0, orderItemList.size() - 1)
                .filter(i -> orderItemList.get(i).getMenu().getFoodName()
                        .equals(orderItemList.get(i + 1).getMenu().getFoodName()))
                .findAny()
                .ifPresent(i -> {
                    throw new OrderException(ErrorMessage.ORDER_NOT_VALID_ERROR_MESSAGE.getErrorMessage());
                });
    }
}
