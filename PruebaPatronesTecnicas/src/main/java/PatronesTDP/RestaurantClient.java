package PatronesTDP;

public class RestaurantClient implements Observer {
    private String name;

    public RestaurantClient(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }
}
