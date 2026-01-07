import java.util.ArrayList;
import java.util.List;

public class Property {
    private String address;
    private String description;
    private float averageRating;
    private List<Room> rooms;

    public Property(String address, String description, List<Room> rooms) {
        this.address = address;
        this.description = description;
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
