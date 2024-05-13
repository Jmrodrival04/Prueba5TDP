package PatronesTDP;
// Aplicacion del Patron Factory Entrega 1
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
                throw new IllegalArgumentException("Unknown restaurant type: " + type);
        }
    }
}