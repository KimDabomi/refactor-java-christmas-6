package christmas.domain.order;

import christmas.domain.exception.OrderException;
import christmas.domain.exception.OrderDetailsException;
import christmas.domain.menu.Menu;
import java.util.List;

public class OrderDetails {
    public static int getDate(String date) {
        OrderDetailsException.checkDateType(date);

        int visitingDate = Integer.parseInt(date);
        OrderDetailsException.checkDateRange(visitingDate);

        return visitingDate;
    }

    public static Order getOrderItems(String[] menuItems, List<OrderItem> orderItemList) {
        for (String item : menuItems) {
            String[] details = item.split("-");
            OrderDetailsException.checkOrderType(menuItems);

            String menuName = details[0].trim();
            String quantity = details[1].trim();

            Menu menu = Menu.of(Menu.removeWhiteSpace(menuName));

            orderItemList.add(new OrderItem(menu, quantity));
        }

        OrderException.checkOrderItemExceptions(orderItemList);
        return new Order(orderItemList);
    }
}
