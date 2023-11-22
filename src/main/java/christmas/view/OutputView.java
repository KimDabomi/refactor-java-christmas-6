package christmas.view;

import christmas.domain.event.DiscountEvent;
import christmas.domain.event.EventBadge;
import christmas.domain.event.NumberOfEvent;
import christmas.domain.order.Order;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class OutputView {
    private Order order;

    public OutputView() {
    }

    public void showOrderItems() {
        if (order != null) {
            order.printOrderItems();
        }
    }

    public void showEventPreview(int date) {
        System.out.printf(OutputViewMessage.SHOW_PREVIEW_EVENT_MESSAGE.getOutputViewMessage(), date);
        System.out.println();
    }

    public void showOrderList(Order order) {
        if (order != null) {
            System.out.println(OutputViewMessage.SHOW_ORDER_MENU_MESSAGE.getOutputViewMessage());
            order.printOrderList();
        }
    }

    public void showTotalAmountBeforeDiscount(Order order) {
        if (order != null) {
            System.out.println(OutputViewMessage.SHOW_BEFORE_DISCOUNT_AMOUNT_MESSAGE.getOutputViewMessage());
            String totalAmountBeforeDiscount = formatAmount(order.getTotalAmountBeforeDiscount());
            System.out.printf(OutputViewMessage.SHOW_STRING_AMOUNT_MESSAGE.getOutputViewMessage(), totalAmountBeforeDiscount);
            System.out.println();
        }
    }

    public void showGiftMenu(Order order, LocalDate date) {
        int champagneDiscount = DiscountEvent.GIFT_CHAMPAGNE.calculateDiscount(order, date);
        System.out.println(OutputViewMessage.SHOW_GIFT_TITLE_MESSAGE.getOutputViewMessage());

        if (champagneDiscount > NumberOfEvent.ZERO.getNumberOfEvent()) {
            System.out.println(OutputViewMessage.SHOW_GIFT_MENU_MESSAGE.getOutputViewMessage());
        }

        if (champagneDiscount == NumberOfEvent.ZERO.getNumberOfEvent()){
            System.out.println(OutputViewMessage.SHOW_NONE_MESSAGE.getOutputViewMessage());
        }
    }

    public void showDiscountList(Order order, LocalDate date) {
        System.out.println(OutputViewMessage.SHOW_EVENT_LIST_TITLE_MESSAGE.getOutputViewMessage());

        if (order.getTotalAmountBeforeDiscount() >= NumberOfEvent.TEN_THOUSAND_WON.getNumberOfEvent()) {
            showDiscount(order, date);
        }

        if (order.getTotalAmountBeforeDiscount() < NumberOfEvent.TEN_THOUSAND_WON.getNumberOfEvent()) {
            System.out.println(OutputViewMessage.SHOW_NONE_MESSAGE.getOutputViewMessage());
        }
    }

    public void showTotalDiscountAmount(Order order, LocalDate date) {
        System.out.println(OutputViewMessage.SHOW_TOTAL_EVENT_TITLE_MESSAGE.getOutputViewMessage());
        int totalAmount = DiscountEvent.getTotalDiscountAmount(order, date);
        String totalDiscountAmount = formatAmount(totalAmount);

        if (order.getTotalAmountBeforeDiscount() >= NumberOfEvent.TEN_THOUSAND_WON.getNumberOfEvent()) {
            System.out.printf(OutputViewMessage.SHOW_MINUS_AMOUNT_MESSAGE.getOutputViewMessage(), totalDiscountAmount);
            System.out.println();
        }

        if (order.getTotalAmountBeforeDiscount() < NumberOfEvent.TEN_THOUSAND_WON.getNumberOfEvent()) {
            totalAmount = 0;
            System.out.printf(OutputViewMessage.SHOW_INT_AMOUNT_MESSAGE.getOutputViewMessage(), totalAmount);
            System.out.println();
        }
    }

    public void showFinalAmount(Order order, LocalDate date) {
        int finalAmount = DiscountEvent.getTotalAmount(order, date);
        String totalFinalAmount = formatAmount(finalAmount);

        System.out.println(OutputViewMessage.SHOW_FINAL_AMOUNT_MESSAGE.getOutputViewMessage());
        System.out.printf(OutputViewMessage.SHOW_STRING_AMOUNT_MESSAGE.getOutputViewMessage(), totalFinalAmount);
    }

    public void showBadge(Order order, LocalDate date) {
        int totalAmount = DiscountEvent.getTotalDiscountAmount(order, date);
        System.out.println();
        System.out.println(OutputViewMessage.SHOW_BADGE_MESSAGE.getOutputViewMessage());

        if (totalAmount > 0) {
            System.out.println(EventBadge.getBadgeForDiscount(totalAmount));
        }

        if (totalAmount == 0) {
            System.out.println(OutputViewMessage.SHOW_NONE_MESSAGE.getOutputViewMessage());
        }
    }

    private void showDiscount(Order order, LocalDate date) {
        showWeekdayDiscount(order, date);
        showWeekendDiscount(order, date);
        showSpecialDiscount(order, date);
        showChampagneGift(order, date);
    }

    private void showChristmasDiscount(Order order, LocalDate date) {
        String christmasDiscountAmount = formatAmount(DiscountEvent.CHRISTMAS_D_DAY.calculateDiscount(order, date));

        if (!christmasDiscountAmount.equals(OutputViewMessage.NONE.getOutputViewMessage())) {
            System.out.printf(OutputViewMessage.SHOW_CHRISTMAS_EVENT_MESSAGE.getOutputViewMessage(), christmasDiscountAmount);
            System.out.println();
        }
    }

    private void showWeekdayDiscount(Order order, LocalDate date) {
        String weekdayDiscountAmount = formatAmount(DiscountEvent.WEEKDAY_DISCOUNT.calculateDiscount(order, date));

        if (!weekdayDiscountAmount.equals(OutputViewMessage.NONE.getOutputViewMessage())) {
            System.out.printf(OutputViewMessage.SHOW_WEEKDAY_EVENT_MESSAGE.getOutputViewMessage(), weekdayDiscountAmount);
            System.out.println();
        }
    }

    private void showWeekendDiscount(Order order, LocalDate date) {
        String weekendDiscountAmount = formatAmount(DiscountEvent.WEEKEND_DISCOUNT.calculateDiscount(order, date));

        if (!weekendDiscountAmount.equals(OutputViewMessage.NONE.getOutputViewMessage())) {
            System.out.printf(OutputViewMessage.SHOW_WEEKEND_EVENT_MESSAGE.getOutputViewMessage(), weekendDiscountAmount);
            System.out.println();
        }
    }

    private void showSpecialDiscount(Order order, LocalDate date) {
        String specialDiscountAmount = formatAmount(DiscountEvent.SPECIAL_DISCOUNT.calculateDiscount(order, date));

        if (!specialDiscountAmount.equals(OutputViewMessage.NONE.getOutputViewMessage())) {
            System.out.printf(OutputViewMessage.SHOW_SPECIAL_EVENT_MESSAGE.getOutputViewMessage(), specialDiscountAmount);
            System.out.println();
        }
    }

    private void showChampagneGift(Order order, LocalDate date) {
        String champagneGiftAmount = formatAmount(DiscountEvent.GIFT_CHAMPAGNE.calculateDiscount(order, date));

        if (!champagneGiftAmount.equals(OutputViewMessage.NONE.getOutputViewMessage())) {
            System.out.printf(OutputViewMessage.SHOW_GIFT_EVENT_MESSAGE.getOutputViewMessage(), champagneGiftAmount);
            System.out.println();
        }
    }

    private String formatAmount(int amount) {
        DecimalFormat decFormat = new DecimalFormat(OutputViewMessage.AMOUNT_FORMAT.getOutputViewMessage());
        return decFormat.format(amount);
    }
}
