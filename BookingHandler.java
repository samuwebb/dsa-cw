import java.util.List;
import java.util.Map;

public class BookingHandler {
    SystemData systemData;

    public BookingHandler(SystemData systemData) {
        this.systemData = systemData;
    }

    public Booking createBooking(Student student, Property property, String status, String startDate, String endDate) {
        Booking newBooking = new Booking(student, property, status, startDate, endDate);
        systemData.addBooking(newBooking);
        return newBooking;
    }

    public List<Booking> getBookingsByEmail(String email) {
        Map<String, List<Booking>> bookingsByEmail = systemData.getBookingsByEmail();
        List<Booking> bookings = bookingsByEmail.get(email);
        return bookings;
    }
}
