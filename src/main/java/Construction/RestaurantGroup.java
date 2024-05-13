package Construction;
// Aplicacion de los patrones composite y adapter entregas 3 y 4
import java.util.ArrayList;
import java.util.List;

public class RestaurantGroup implements Restaurant {
    private List<Restaurant> restaurants = new ArrayList<>();

    @Override
    public void serveCustomers() {
        for (Restaurant restaurant : restaurants) {
            restaurant.serveCustomers();
        }
    }

    @Override
    public void setServiceStrategy(ServiceStrategy strategy) {

    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
}