// Reservation.java
public class Reservation {
    private Client client;
    private Room room;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(Client client, Room room, String checkInDate, String checkOutDate) {
        this.client = client;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Client getClient() {
        return client;
    }

    public Room getRoom() {
        return room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }
}
