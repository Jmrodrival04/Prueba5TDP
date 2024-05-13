package Construction;
public class Main {
    public static void main(String[] args) {
        // Obtener la instancia del administrador de restaurantes (Singleton)
        RestaurantManager manager = RestaurantManager.getInstance();

        // Crear diferentes tipos de restaurantes
        Restaurant fastFoodRestaurant = manager.createRestaurant("fastfood");
        Restaurant themeRestaurant = manager.createRestaurant("theme");
        Restaurant fineDiningRestaurant = manager.createRestaurant("finedining");

        // Configurar estrategias de servicio para cada restaurante
        fastFoodRestaurant.setServiceStrategy(new CasualServiceStrategy());
        themeRestaurant.setServiceStrategy(new ThemedServiceStrategy());
        fineDiningRestaurant.setServiceStrategy(new FineDiningServiceStrategy());

        // Servir clientes en cada restaurante
        System.out.println("Fast Food Restaurant:");
        fastFoodRestaurant.serveCustomers();

        System.out.println("Theme Restaurant:");
        themeRestaurant.serveCustomers();

        System.out.println("Fine Dining Restaurant:");
        fineDiningRestaurant.serveCustomers();
    }
}
