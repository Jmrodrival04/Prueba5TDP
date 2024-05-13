package org.example;
public class RestaurantFactory {
    public Restaurant getRestaurant(String type) {
        switch (type.toLowerCase()) {
            case "fastfood":
                return new FastFoodRestaurant();
            case "theme":
                return new ThemeRestaurant();
            case "finedining":
                return new FineDiningRestaurant();
            default:
                return null;
        }
    }
}
