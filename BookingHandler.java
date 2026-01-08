import java.util.List;
import java.util.Map;

public class BookingHandler {
    SystemData systemData;

    public BookingHandler(SystemData systemData) {
        this.systemData = systemData;
    }

    public Booking createBooking(Student student, Room room, String status, String startDate, String endDate) {
        if (student == null) {
            System.out.println("You are not logged in as a student.");
            return null;
        }

        Booking newBooking = new Booking(student, room, status, startDate, endDate);
        systemData.addBooking(newBooking);
        return newBooking;
    }

    public List<Booking> getBookingsByEmail(String email) {
        Map<String, List<Booking>> bookingsByEmail = systemData.getBookingsByEmail();
        List<Booking> bookings = bookingsByEmail.get(email);
        return bookings;
    }
}
