// Room.java
public class Room {
    private int number;
    private String type;
    private boolean available;

    public Room(int number, String type) {
        this.number = number;
        this.type = type;
        this.available = true; // disponible por defecto
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
