import java.util.ArrayList;
import java.util.List;

public class SystemData {
    private List<Student> students = new ArrayList<>();
    private List<Homeowner> homeowners = new ArrayList<>();
    private List<Property> properties = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public List<Homeowner> getHomeowners() {
        return homeowners;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
