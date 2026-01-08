import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Reponsible for handling data flow for properties
public class PropertyHandler {
    SystemData systemData;

    public PropertyHandler(SystemData systemData) { // Retrieve system data from main program
        this.systemData = systemData;
    }

    // Create a new property from criteria
    public Property listProperty(String address, String city, Homeowner homeowner, String description) {
        // Create new property object
        Property newProperty = new Property(systemData.getCurrentHomeowner(), address, city, description);
        homeowner.addProperty(newProperty);
        systemData.addProperty(newProperty);
        return newProperty;
    }

    public void deleteProperty(Property property) {
        systemData.getProperties().remove(property);
    }

    // Create a new room from criteria
    public Room createRoom(Property property, String roomType, float monthlyRent, String description, String status,
            String startDate, String endDate) {
        // Create new room object
        Room newRoom = new Room(property, roomType, monthlyRent, description, status, startDate, endDate);
        property.addRoom(newRoom);
        return newRoom;
    }

    // Hashmap to retrieve property from keyword address
    public Property getPropertyFromAddress(String address) {
        // address: Property
        Map<String, Property> addressRegistry = systemData.getAddressRegistry();
        Property property = addressRegistry.get(address);
        return property;
    }

    // Hashmap to retrieve properties from keyword city
    public List<Property> getPropertiesByCity(String city) {
        // city, List<Property>
        Map<String, List<Property>> propertiesByCity = systemData.getPropertiesByCity();
        List<Property> properties = propertiesByCity.get(city);
        return properties;
    }

    public boolean doesPropertyExists(String address) {
        return getPropertyFromAddress(address) != null;
    }
}
