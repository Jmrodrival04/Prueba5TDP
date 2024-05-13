package PatronesTDP;
// Aplicacion del patron singleton entrega 1
public class RestaurantManager {
    private static RestaurantManager instance;
    private RestaurantFactory factory;

    private RestaurantManager() {
        this.factory = new RestaurantFactory();
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