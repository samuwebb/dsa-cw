public class Booking {
    private Student student;
    private Property property;
    private String status;
    private String startDate;
    private String endDate;

    public Booking(Student student, Property property, String status, String startDate, String endDate) {
        this.student = student;
        this.property = property;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Student getStudent() {
        return student;
    }

    public Property getProperty() {
        return property;
    }

    public String getStatus() {
        return status;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
