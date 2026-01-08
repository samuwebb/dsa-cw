import java.util.ArrayList;
import java.util.List;

public class Property {
    private Homeowner owner;
    private String address;
    private String city;
    private String description;
    private float averageRating;
    private List<Room> rooms = new ArrayList<>();

    public Property(Homeowner owner, String address, String city, String description) {
        this.owner = owner;
        this.address = address;
        this.city = city;
        this.description = description;
    }

    public Homeowner getOwner() {
        return owner;
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
