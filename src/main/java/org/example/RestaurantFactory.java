package org.example;
// Patron Factory de la entrega 1
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
