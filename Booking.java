public class Booking {
    private Student student;
    private Room room;
    private String status;
    private String startDate;
    private String endDate;

    public Booking(Student student, Room room, String status, String startDate, String endDate) {
        this.student = student;
        this.room = room;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Student getStudent() {
        return student;
    }

    public Room getRoom() {
        return room;
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

    public void setStatus(String newStatus) {
        status = newStatus;
    }
}
