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
}
