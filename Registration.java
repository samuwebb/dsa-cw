import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Registration {
    SystemData systemData;

    public Registration(SystemData systemData) {
        this.systemData = systemData;
    }

    public Student registerStudent(String name, String email, String passHash, String studentId,
            String university) {
        if (!isStudentEmailUnique(email)) {
            System.out.println("Email already exists.");
            return null;
        }

        if (!isValidEmail(email)) {
            System.out.println("Email is not valid.");
            return null;
        }

        Student newStudent = new Student(name, email, passHash, studentId, university);
        systemData.addStudent(newStudent);
        return newStudent;
    }

    public Homeowner registerHomeowner(String name, String email, String passHash,
            List<Property> properties) {
        if (!isHomeownerEmailUnique(email)) {
            return null;
        }

        if (!isValidEmail(email)) {
            return null;
        }

        Homeowner newOwner = new Homeowner(name, email, passHash, properties);
        systemData.addHomeowner(newOwner);
        return newOwner;
    }

    public Student loginStudent(String email, String password) {
        Map<String, Student> studentEmailIndex = systemData.getStudentEmailIndex();
        Student student = studentEmailIndex.get(email);

        if (!isPasswordValid(password, student.getPassword())) {
            System.out.println("Password is invalid.");
            return null;
        }
        return student;
    }

    public Homeowner loginHomeowner(String email, String password) {
        Map<String, Homeowner> homeownerEmailIndex = systemData.getHomeownerEmailIndex();
        Homeowner homeowner = homeownerEmailIndex.get(email);

        if (!isPasswordValid(password, homeowner.getPassword())) {
            System.out.println("Password is invalid.");
            return null;
        }
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

    public boolean isValidEmail(String email) {
        final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isPasswordValid(String password1, String password2) {
        if (password1.equals(password2)) {
            return true;
        }
        return false;
    }
}
