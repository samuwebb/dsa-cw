import java.util.ArrayList;
import java.util.List;

public class Homeowner extends User {
    private List<Property> properties = new ArrayList<>(); // Create empty array to populate properties

    public Homeowner(String name, String email, String passHash, List<Property> properties) {
        super(name, email, passHash); // Inheriting the user attributes
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }
}
