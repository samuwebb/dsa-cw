public class Student extends User {
    private String studentId;
    private String university;

    public Student(String name, String email, String passHash, String studentId, String university) {
        super(name, email, passHash); // Inheriting the user attributes
        this.studentId = studentId;
        this.university = university;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getUniversity() {
        return university;
    }
}
