// ReservationRepository.java
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository implements IReservationRepository {
    private List<Reservation> reservations;

    public ReservationRepository() {
        reservations = new ArrayList<>();
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservations;
    }
}
