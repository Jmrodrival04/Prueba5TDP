package PatronesTDP;

public class Reservation {
    private String restaurantType;
    private int tableId;
    private String clientName;

    public Reservation(String restaurantType, int tableId, String clientName) {
        this.restaurantType = restaurantType;
        this.tableId = tableId;
        this.clientName = clientName;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public int getTableId() {
        return tableId;
    }

    public String getClientName() {
        return clientName;
    }
}
