import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropertyHandler {
    SystemData systemData;

    public PropertyHandler(SystemData systemData) {
        this.systemData = systemData;
    }

    public Property listProperty(String address, String city, String description) {
        Property newProperty = new Property(address, city, description);
        systemData.addProperty(newProperty);
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
        Map<String, Property> addressRegistry = systemData.getAddressRegistry();
        Property property = addressRegistry.get(address);
        return property;
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
