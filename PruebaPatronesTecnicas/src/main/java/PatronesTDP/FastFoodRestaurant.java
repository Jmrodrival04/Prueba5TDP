package PatronesTDP;
public class FastFoodRestaurant implements Restaurant {
    private ServiceStrategy strategy;

    @Override
    public void serveCustomers() {
        strategy.serve();
    }

    @Override
    public void setServiceStrategy(ServiceStrategy strategy) {
        this.strategy = strategy;
    }
}