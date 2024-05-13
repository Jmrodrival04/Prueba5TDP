package org.example;
// Patron Singleton de la entrega 3
public class RestaurantManager {
    private static RestaurantManager instance;
    private RestaurantFactory factory;

    private RestaurantManager() {
        factory = new RestaurantFactory();
    }

    public static synchronized RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public Restaurant createRestaurant(String type) {
        return factory.getRestaurant(type);
    }
}
