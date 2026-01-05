import java.util.ArrayList;
import java.util.List;

public class Registration {

    public Homeowner registerHomeowner(String userId, String name, String email, String passHash,
            List<Property> properties) {
        Homeowner newOwner = new Homeowner(userId, name, email, passHash, properties);
        return newOwner;
    }

    public Student registerStudent(String userId, String name, String email, String passHash, String studentId,
            String university) {
        Student newStudent = new Student(userId, name, email, passHash, studentId, university);
        return newStudent;
    }
}
