import java.util.ArrayList;
import java.util.List;

public class Homeowner extends User {
    private List<Property> properties;

    public Homeowner(String userId, String name, String email, String passHash, List<Property> properties) {
        super(userId, name, email, passHash);
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
