package Construction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RestaurantManager manager = RestaurantManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = null; // Inicializando a null

        while (true) {
            System.out.println("Welcome to the Restaurant Management System!");
            System.out.println("Select an option:");
            System.out.println("1. Create Fast Food Restaurant");
            System.out.println("2. Create Theme Restaurant");
            System.out.println("3. Create Fine Dining Restaurant");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    restaurant = manager.createRestaurant("fastfood");
                    restaurant.setServiceStrategy(new CasualServiceStrategy());
                    System.out.println("Fast Food Restaurant created and strategy set.");
                    break;
                case 2:
                    restaurant = manager.createRestaurant("theme");
                    restaurant.setServiceStrategy(new ThemedServiceStrategy());
                    System.out.println("Theme Restaurant created and strategy set.");
                    break;
                case 3:
                    restaurant = manager.createRestaurant("finedining");
                    restaurant.setServiceStrategy(new FineDiningServiceStrategy());
                    System.out.println("Fine Dining Restaurant created and strategy set.");
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    continue; // Continúa al próximo ciclo del bucle si la elección no es válida
            }

            // Comprobación de seguridad para asegurar que restaurant no sea null
            if (restaurant != null) {
                System.out.println("Serving customers at the restaurant:");
                restaurant.serveCustomers();
                System.out.println();
            } else {
                System.out.println("No restaurant was created, please make a valid selection.");
            }
        }
    }
}
