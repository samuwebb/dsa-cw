import java.util.ArrayList;
import java.util.List;

public class PropertyHandler {
    SystemData systemData;

    public PropertyHandler(SystemData systemData) {
        this.systemData = systemData;
    }

    public Property listProperty(String address, String description) {
        Property newProperty = new Property(address, description);
        systemData.getProperties().add(newProperty);
        return newProperty;
    }

    public void deleteProperty(Property property) {
        systemData.getProperties().remove(property);
    }

    public Room createRoom(Property property, String roomType, float monthlyRent, String description, String status,
            String startDate, String endDate) {
        Room newRoom = new Room(property, roomType, monthlyRent, description, status, startDate, endDate);
        property.addRoom(newRoom);
        return newRoom;
    }

    public Property getPropertyFromAddress(String address) {
        Property theProperty = null;

        for (Property property : systemData.getProperties()) {
            if (address.equals(property.getAddress())) {
                theProperty = property;
            }
        }
        return theProperty;
    }

    public boolean doesPropertyExists(String address) {
        for (Property property : systemData.getProperties()) {
            if (address.equals(property.getAddress())) {
                return true;
            }
        }
        return false;
    }
}
