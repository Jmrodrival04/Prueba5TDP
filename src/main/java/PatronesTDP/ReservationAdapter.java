package PatronesTDP;
//Implementacio del Patron Adapter entrega 2
public class ReservationAdapter implements ReservationSystem {
    private ExternalReservationSystem externalSystem;

    public ReservationAdapter(ExternalReservationSystem externalSystem) {
        this.externalSystem = externalSystem;
    }

    @Override
    public void reserveTable(int tableId) {
        externalSystem.bookTable(tableId); // Adaptación de la llamada al método externo.
    }
}