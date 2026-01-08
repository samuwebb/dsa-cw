import java.util.ArrayList;
import java.util.List;

public class Homeowner extends User {
    private List<Property> properties;

    public Homeowner(String name, String email, String passHash, List<Property> properties) {
        super(name, email, passHash);
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }
}
