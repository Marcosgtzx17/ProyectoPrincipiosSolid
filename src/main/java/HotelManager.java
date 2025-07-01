// HotelManager.java
import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    private List<Client> clients;
    private List<Room> rooms;
    private IReservationRepository reservationRepo;

    public HotelManager(IReservationRepository reservationRepo) {
        this.reservationRepo = reservationRepo;
        this.clients = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public void registerClient(String name, String document) {
        Client client = new Client(name, document);
        clients.add(client);
        System.out.println(" Cliente registrado: " + name);
    }

    public void registerRoom(int number, String type) {
        Room room = new Room(number, type);
        rooms.add(room);
        System.out.println(" Habitación registrada: " + number + " (" + type + ")");
    }

    public void makeReservation(String clientDocument, int roomNumber, String checkIn, String checkOut) {
        Client client = findClientByDocument(clientDocument);
        Room room = findRoomByNumber(roomNumber);

        if (client != null && room != null && room.isAvailable()) {
            Reservation reservation = new Reservation(client, room, checkIn, checkOut);
            reservationRepo.addReservation(reservation);
            room.setAvailable(false);
            System.out.println(" Reserva realizada para " + client.getName() + " en habitación " + room.getNumber());
        } else {
            System.out.println("Error: Cliente o habitación no disponible.");
        }
    }

    public void listReservations() {
        List<Reservation> reservations = reservationRepo.getAllReservations();
        if (reservations.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            System.out.println("\n Listado de Reservas:");
            for (Reservation r : reservations) {
                System.out.println("- Cliente: " + r.getClient().getName()
                        + " | Habitación: " + r.getRoom().getNumber()
                        + " | Check-in: " + r.getCheckInDate()
                        + " | Check-out: " + r.getCheckOutDate());
            }
        }
    }

    private Client findClientByDocument(String document) {
        for (Client c : clients) {
            if (c.getDocument().equals(document)) {
                return c;
            }
        }
        return null;
    }

    private Room findRoomByNumber(int number) {
        for (Room r : rooms) {
            if (r.getNumber() == number) {
                return r;
            }
        }
        return null;
    }
}
