import java.util.List;
import java.util.Map;

// Responsible for handing data flow for bookings
public class BookingHandler {
    SystemData systemData;

    public BookingHandler(SystemData systemData) { // Retrieve system data from main program
        this.systemData = systemData;
    }

    // Create a new booking from criteria
    public Booking createBooking(Student student, Room room, String status, String startDate, String endDate) {
        if (student == null) { // Check if student is logged in
            System.out.println("You are not logged in as a student.");
            return null;
        }

        if (status == "Accepted") { // Check if a booking is already accepted from another user
            System.out.println("Room is already booked.");
        }

        if (room.getStatus() == "Occupied") { // Check if a room is occupied by another user
            System.out.println("Room is already occupied.");
        }

        // Create a new booking and add it to system data
        Booking newBooking = new Booking(student, room, status, startDate, endDate);
        systemData.addBooking(newBooking);
        return newBooking;
    }

    // Hashmap to retrieve bookings from keyword email
    public List<Booking> getBookingsByEmail(String email) {
        // email: List<Bookings>
        Map<String, List<Booking>> bookingsByEmail = systemData.getBookingsByEmail();
        List<Booking> bookings = bookingsByEmail.get(email);
        return bookings;
    }

    // Hashmap to retrieve bookings from keyword owner
    public List<Booking> getBookingsByOwner(Homeowner owner) {
        // Homeowner, List<Booking>
        Map<Homeowner, List<Booking>> bookingsByOwner = systemData.getBookingsByOwner();
        List<Booking> bookings = bookingsByOwner.get(owner);
        return bookings;
    }
}
