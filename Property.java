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
}
