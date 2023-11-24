package christmas.domain.menu;

import christmas.domain.exception.ErrorMessage;
import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP(Category.APPETIZER, "양송이수프", 6000),
    TAPAS(Category.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(Category.APPETIZER, "시저샐러드", 8000),
    T_BONE_STEAK(Category.MAIN, "티본스테이크", 55000),
    BBQ_RIBS(Category.MAIN, "바비큐립", 54000),
    SEAFOOD_PASTA(Category.MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(Category.MAIN, "크리스마스파스타", 25000),
    CHOCOLATE_CAKE(Category.DESSERT, "초코케이크", 15000),
    ICE_CREAM(Category.DESSERT, "아이스크림", 5000),
    ZERO_COLA(Category.DRINK, "제로콜라", 3000),
    RED_WINE(Category.DRINK, "레드와인", 60000),
    CHAMPAGNE(Category.DRINK, "샴페인", 25000);

    private static final String whiteSpace = " ";
    private static final String nonexistent = "";

    private final Category category;
    private final String foodName;
    private final int price;

    Menu(Category category, String foodName, int price) {
        this.category = category;
        this.foodName = foodName;
        this.price = price;
    }

    public String getCategory() {
        return category.getDescription();
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public static String removeWhiteSpace(String foodName) {
        return foodName.replace(whiteSpace, nonexistent);
    }

    public static Menu of(final String foodName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getFoodName().equalsIgnoreCase(foodName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ORDER_NOT_VALID_ERROR_MESSAGE.getErrorMessage()));
    }
}
