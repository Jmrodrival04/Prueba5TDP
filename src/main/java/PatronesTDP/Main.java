package PatronesTDP;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantManager restaurantManager = RestaurantManager.getInstance();

        System.out.println("Bienvenido al sistema de gestión de restaurantes");

        List<Reservation> reservations = new ArrayList<>();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú:");
            System.out.println("1. Seleccionar tipo de restaurante");
            System.out.println("2. Ver reservas");
            System.out.println("3. Salir");
            System.out.print("Ingrese el número correspondiente a la opción deseada: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    selectRestaurant(scanner, restaurantManager, reservations);
                    break;
                case 2:
                    viewReservations(reservations);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }

    private static void selectRestaurant(Scanner scanner, RestaurantManager restaurantManager, List<Reservation> reservations) {
        System.out.println("\nSeleccione el tipo de restaurante:");
        System.out.println("1. Comida Rápida");
        System.out.println("2. Alta Cocina");
        System.out.println("3. Restaurante Temático");
        System.out.print("Ingrese el número correspondiente: ");
        int restaurantTypeChoice = scanner.nextInt();

        Restaurant restaurant = null;
        String restaurantType = "";

        switch (restaurantTypeChoice) {
            case 1:
                restaurant = restaurantManager.createRestaurant("fastfood");
                restaurantType = "Comida Rápida";
                break;
            case 2:
                restaurant = restaurantManager.createRestaurant("finedining");
                restaurantType = "Alta Cocina";
                break;
            case 3:
                restaurant = restaurantManager.createRestaurant("theme");
                restaurantType = "Restaurante Temático";
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        System.out.println("Ha seleccionado: " + restaurantType);

        // Reservar una mesa
        System.out.print("Ingrese su nombre para la reserva: ");
        String clientName = scanner.next();
        System.out.print("Ingrese el número de mesa que desea reservar: ");
        int tableId = scanner.nextInt();

        ExternalReservationSystem externalSystem = new ExternalReservationSystem();
        ReservationAdapter reservationAdapter = new ReservationAdapter(externalSystem);
        reservationAdapter.reserveTable(tableId);

        reservations.add(new Reservation(restaurantType, tableId, clientName));

        // Configurar la estrategia de servicio para el restaurante
        System.out.println("\nSeleccione la estrategia de servicio:");
        System.out.println("1. Servicio Casual");
        System.out.println("2. Alta Cocina");
        System.out.println("3. Servicio Temático");
        System.out.print("Ingrese el número correspondiente: ");
        int serviceStrategyChoice = scanner.nextInt();

        ServiceStrategy serviceStrategy = null;
        String serviceStrategyType = "";

        switch (serviceStrategyChoice) {
            case 1:
                serviceStrategy = new CasualServiceStrategy();
                serviceStrategyType = "Servicio Casual";
                break;
            case 2:
                serviceStrategy = new FineDiningServiceStrategy();
                serviceStrategyType = "Alta Cocina";
                break;
            case 3:
                serviceStrategy = new ThemedServiceStrategy();
                serviceStrategyType = "Servicio Temático";
                break;
            default:
                System.out.println("Opción no válida. Se utilizará el servicio predeterminado.");
                serviceStrategy = new CasualServiceStrategy();
                serviceStrategyType = "Servicio Casual";
                break;
        }

        System.out.println("Ha seleccionado: " + serviceStrategyType);

        restaurant.setServiceStrategy(serviceStrategy);

        // Crear un cliente de restaurante
        RestaurantClient client = new RestaurantClient(clientName);
        MenuUpdates menuUpdates = new MenuUpdates();
        menuUpdates.registerObserver(client);

        // Interacción con el restaurante
        System.out.println("\nBienvenido " + clientName + ". ¡Disfrute de su comida en " + restaurantType + " con " + serviceStrategyType + "!");
        restaurant.serveCustomers();
    }

    private static void viewReservations(List<Reservation> reservations) {
        System.out.println("\nReservas:");
        if (reservations.isEmpty()) {
            System.out.println("No hay reservas.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println("- Tipo de Restaurante: " + reservation.getRestaurantType() + ", Mesa: " + reservation.getTableId() + ", Cliente: " + reservation.getClientName());
            }
        }
    }
}
