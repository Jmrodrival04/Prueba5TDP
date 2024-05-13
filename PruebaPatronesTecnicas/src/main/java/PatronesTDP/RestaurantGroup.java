package PatronesTDP;
// Aplicacion del patron Composite Entrega 2
import java.util.ArrayList;
import java.util.List;


public class RestaurantGroup implements Restaurant {
    private List<Restaurant> restaurants = new ArrayList<>();
    private ServiceStrategy serviceStrategy; // Estrategia de servicio común, si aplicable.

    @Override
    public void serveCustomers() {
        for (Restaurant restaurant : restaurants) {
            restaurant.serveCustomers();
        }
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    @Override
    public void setServiceStrategy(ServiceStrategy strategy) {
        this.serviceStrategy = strategy;
        for (Restaurant restaurant : restaurants) {
            restaurant.setServiceStrategy(strategy);
        }
    }
}