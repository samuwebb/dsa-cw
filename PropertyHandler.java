import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropertyHandler {
    SystemData systemData;

    public PropertyHandler(SystemData systemData) {
        this.systemData = systemData;
    }

    public Property listProperty(String address, String city, Homeowner homeowner, String description) {
        Property newProperty = new Property(systemData.getCurrentHomeowner(), address, city, description);
        homeowner.addProperty(newProperty);
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

    public List<Property> getPropertiesByCity(String city) {
        Map<String, List<Property>> propertiesByCity = systemData.getPropertiesByCity();
        List<Property> properties = propertiesByCity.get(city);
        return properties;
    }

    public boolean doesPropertyExists(String address) {
        return getPropertyFromAddress(address) != null;
    }
}
