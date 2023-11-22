package christmas.domain.event;

import christmas.view.ViewMessage;
import java.util.function.Predicate;

public enum EventBadge {
    STAR("별", totalDiscount -> totalDiscount >= 5000 && totalDiscount < 10000),
    TREE("트리", totalDiscount -> totalDiscount >=10000 && totalDiscount < 20000),
    SANTA("산타", totalDiscount -> totalDiscount >= 20000);

    private final String badge;
    private final Predicate<Integer> condition;

    EventBadge(String badge, Predicate<Integer> condition) {
        this.badge = badge;
        this.condition = condition;
    }

    public static String getBadgeForDiscount(int totalDiscount) {
        for (EventBadge badge : EventBadge.values()) {
            if (badge.condition.test(totalDiscount)) {
                return badge.badge;
            }
        }

        return ViewMessage.SHOW_NONE_MESSAGE.getViewMessage();
    }
}
