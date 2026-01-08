import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Responsible for handling data flow for users
public class Registration {
    SystemData systemData;

    public Registration(SystemData systemData) { // Retrieve system data from main program
        this.systemData = systemData;
    }

    // Create new student from criteria
    public Student registerStudent(String name, String email, String passHash, String studentId,
            String university) {
        if (!isStudentEmailUnique(email)) { // Check if email already exists
            System.out.println("Email already exists.");
            return null;
        }

        if (!isValidEmail(email)) { // Check if email is valid
            System.out.println("Email is not valid.");
            return null;
        }

        // Create new student object and add it to system data
        Student newStudent = new Student(name, email, passHash, studentId, university);
        systemData.addStudent(newStudent);
        return newStudent;
    }

    // Create new homeowner from criteria
    public Homeowner registerHomeowner(String name, String email, String passHash,
            List<Property> properties) {
        if (!isHomeownerEmailUnique(email)) { // Check if email already exists
            return null;
        }

        if (!isValidEmail(email)) { // Check if email is valid
            return null;
        }

        // Create new homeowner object and add it to system data
        Homeowner newOwner = new Homeowner(name, email, passHash, properties);
        systemData.addHomeowner(newOwner);
        return newOwner;
    }

    // Login to student account using email and password
    public Student loginStudent(String email, String password) {
        // Retrieve hashmap from system data
        Map<String, Student> studentEmailIndex = systemData.getStudentEmailIndex();
        Student student = studentEmailIndex.get(email);

        if (!isPasswordValid(password, student.getPassword())) { // Checks if password matches user
            System.out.println("Password is invalid.");
            return null;
        }
        return student;
    }

    // Login to homeowner account using email and password
    public Homeowner loginHomeowner(String email, String password) {
        // Retrieve hashmap from system data
        Map<String, Homeowner> homeownerEmailIndex = systemData.getHomeownerEmailIndex();
        Homeowner homeowner = homeownerEmailIndex.get(email);

        if (!isPasswordValid(password, homeowner.getPassword())) { // Checks if password matches user
            System.out.println("Password is invalid.");
            return null;
        }
        return homeowner;
    }

    // Hashmap to retrieve students from keyword email
    public Student getStudentFromEmail(String email) {
        // email: List<Student>
        Map<String, Student> studentEmailIndex = systemData.getStudentEmailIndex();
        Student student = studentEmailIndex.get(email);
        return student;
    }

    // Hashmap to retrieve homeowner from keyword email
    public Homeowner getHomeownerFromEmail(String email) {
        // email: List<Homeowner>
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
        // Regex for email format a@b.c
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
