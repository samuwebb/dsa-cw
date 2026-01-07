import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SystemData {
    private List<Student> students = new ArrayList<>();
    private List<Homeowner> homeowners = new ArrayList<>();
    private List<Property> properties = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private User currentUser;

    private Map<String, User> userEmailIndex = new HashMap<>();
    private Map<String, Property> addressRegistry = new HashMap<>();
    private Map<String, List<Property>> propertiesByCity = new HashMap<>();
    private Map<String, List<Booking>> bookingsByEmail = new HashMap<>();

    public List<Student> getStudents() {
        return students;
    }

    public List<Homeowner> getHomeowners() {
        return homeowners;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public Map<String, User> getUserEmailIndex() {
        return userEmailIndex;
    }

    public Map<String, Property> getAddressRegistry() {
        return addressRegistry;
    }

    public Map<String, List<Property>> getPropertiesByCity() {
        return propertiesByCity;
    }

    public Map<String, List<Booking>> getBookingsByEmail() {
        return bookingsByEmail;
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
        userEmailIndex.put(newStudent.getEmail(), newStudent);
        return;
    }

    public void addHomeowner(Homeowner newHomeowner) {
        homeowners.add(newHomeowner);
        userEmailIndex.put(newHomeowner.getEmail(), newHomeowner);
        return;
    }

    public void addProperty(Property newProperty) {
        properties.add(newProperty);
        addressRegistry.put(newProperty.getAddress(), newProperty);
        propertiesByCity.putIfAbsent(newProperty.getCity(), new ArrayList<>());
        propertiesByCity.get(newProperty.getCity()).add(newProperty);
        return;
    }

    public void addBooking(Booking newBooking) {
        bookings.add(newBooking);
        bookingsByEmail.putIfAbsent(newBooking.getStudent().getEmail(), new ArrayList<>());
        bookingsByEmail.get(newBooking.getStudent().getEmail()).add(newBooking);
        return;
    }

    public void setCurrentUser(User newUser) {
        currentUser = newUser;
    }
}
