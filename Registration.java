import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Registration {
    SystemData systemData;

    public Registration(SystemData systemData) {
        this.systemData = systemData;
    }

    public Student registerStudent(String name, String email, String passHash, String studentId,
            String university) {
        if (!isEmailUnique(email)) {
            return null;
        }

        Student newStudent = new Student(name, email, passHash, studentId, university);
        systemData.addStudent(newStudent);
        return newStudent;
    }

    public Homeowner registerHomeowner(String name, String email, String passHash,
            List<Property> properties) {
        if (!isEmailUnique(email)) {
            return null;
        }

        Homeowner newOwner = new Homeowner(name, email, passHash, properties);
        systemData.addHomeowner(newOwner);
        return newOwner;
    }

    public User getUserFromEmail(String email) {
        Map<String, User> userEmailIndex = systemData.getUserEmailIndex();
        User user = userEmailIndex.get(email);
        return user;
    }

    public boolean isEmailUnique(String email) {
        return getUserFromEmail(email) == null;
    }
}
