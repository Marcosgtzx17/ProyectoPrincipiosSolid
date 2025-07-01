// IReservationRepository.java
import java.util.List;

public interface IReservationRepository {
    void addReservation(Reservation reservation);
    List<Reservation> getAllReservations();
}
