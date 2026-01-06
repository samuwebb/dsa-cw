import java.util.ArrayList;
import java.util.List;

public class PropertyHandler {
    SystemData systemData;

    public PropertyHandler(SystemData systemData) {
        this.systemData = systemData;
    }

    public Property listProperty(String address, String description, List<Room> rooms) {
        Property newProperty = new Property(address, description, rooms);
        systemData.getProperties().add(newProperty);
        return newProperty;
    }

    public Room createRoom(Property property, String roomType, float monthlyRent, String description, String status,
            String startDate, String endDate) {
        Room newRoom = new Room(property, roomType, monthlyRent, description, status, startDate, endDate);
        systemData.getRooms().add(newRoom);
        return newRoom;
    }
}
