import java.util.ArrayList;
import java.util.List;

public class Property {
    private String address;
    private String city;
    private String description;
    private float averageRating;
    private List<Room> rooms = new ArrayList<>();

    public Property(String address, String city, String description) {
        this.address = address;
        this.city = city;
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
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

    public boolean isEmpty() {
        return rooms.isEmpty();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
