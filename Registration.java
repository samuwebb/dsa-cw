import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Registration {
    SystemData systemData;

    public Registration(SystemData systemData) {
        this.systemData = systemData;
    }

    public Student registerStudent(String name, String email, String passHash, String role, String studentId,
            String university) {
        if (!isStudentEmailUnique(email)) {
            return null;
        }

        Student newStudent = new Student(name, email, passHash, role, studentId, university);
        systemData.addStudent(newStudent);
        return newStudent;
    }

    public Homeowner registerHomeowner(String name, String email, String passHash, String role,
            List<Property> properties) {
        if (!isHomeownerEmailUnique(email)) {
            return null;
        }

        Homeowner newOwner = new Homeowner(name, email, passHash, role, properties);
        systemData.addHomeowner(newOwner);
        return newOwner;
    }

    public Student loginStudent(String email) {
        Map<String, Student> studentEmailIndex = systemData.getStudentEmailIndex();
        Student student = studentEmailIndex.get(email);
        return student;
    }

    public Homeowner loginHomeowner(String email) {
        Map<String, Homeowner> homeownerEmailIndex = systemData.getHomeownerEmailIndex();
        Homeowner homeowner = homeownerEmailIndex.get(email);
        return homeowner;
    }

    public Student getStudentFromEmail(String email) {
        Map<String, Student> studentEmailIndex = systemData.getStudentEmailIndex();
        Student student = studentEmailIndex.get(email);
        return student;
    }

    public Homeowner getHomeownerFromEmail(String email) {
        Map<String, Homeowner> homeownerEmailIndex = systemData.getHomeownerEmailIndex();
        Homeowner homeowner = homeownerEmailIndex.get(email);
        return homeowner;

    }

    public boolean isStudentEmailUnique(String email) {
        return getStudentFromEmail(email) == null;
    }

    public boolean isHomeownerEmailUnique(String email) {
        return getHomeownerFromEmail(email) == null;
    }
}
