import java.util.ArrayList;
import java.util.List;

public class Homeowner extends User {
    private List<Property> properties;

    public Homeowner(String name, String email, String passHash, String role, List<Property> properties) {
        super(name, email, passHash, role);
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
