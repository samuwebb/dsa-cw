import java.util.ArrayList;
import java.util.List;

public class Registration {
    SystemData systemData;

    public Registration(SystemData systemData) {
        this.systemData = systemData;
    }

    public Homeowner registerHomeowner(String name, String email, String passHash,
            List<Property> properties) {
        if (!isEmailUnique(email)) {
            return null;
        }

        Homeowner newOwner = new Homeowner(name, email, passHash, properties);
        systemData.getHomeowners().add(newOwner);
        return newOwner;
    }

    public Student registerStudent(String name, String email, String passHash, String studentId,
            String university) {
        if (!isEmailUnique(email)) {
            return null;
        }

        Student newStudent = new Student(name, email, passHash, studentId, university);
        systemData.getStudents().add(newStudent);
        return newStudent;
    }

    public boolean isEmailUnique(String email) {
        List<Student> students = systemData.getStudents();
        List<Homeowner> homeowners = systemData.getHomeowners();

        for (Student student : students) {
            if (email.equals(student.getEmail())) {
                return false;
            }
        }

        for (Homeowner homeowner : homeowners) {
            if (email.equals(homeowner.getEmail())) {
                return false;
            }
        }
        return true;
    }
}
