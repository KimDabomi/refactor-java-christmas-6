package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.order.OrderInformation;
import christmas.domain.order.OrderItem;
import christmas.domain.order.Order;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public InputView() {
    }

    public String readDate() {
        System.out.println(InputViewMessage.START_MESSAGE.getInputViewMessage());
        System.out.println(InputViewMessage.ASK_DATE_MESSAGE.getInputViewMessage());

        return Console.readLine();
    }

    public Order readMenuOrder() {
        System.out.println(InputViewMessage.ASK_ORDER_MENU_QUANTITY_MESSAGE.getInputViewMessage());
        String[] menuItems = Console.readLine().split(InputViewMessage.SPLIT_CRITERIA.getInputViewMessage());
        List<OrderItem> orderItemList = new ArrayList<>();

        return OrderInformation.getOrderItems(menuItems, orderItemList);
    }
}
