import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentRentals {
    public static void main(String[] args) {
        SystemData systemData = new SystemData();
        Registration registration = new Registration(systemData);
        PropertyHandler propertyHandler = new PropertyHandler(systemData);
        BookingHandler bookingHandler = new BookingHandler(systemData);
        Scanner scanner = new Scanner(System.in);

        boolean active = true;
        while (active) {
            displayMainMenu();
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    displayRegistrationMenu(systemData, registration, scanner);
                    break;
                case 2:
                    displayPropertyMenu(systemData, propertyHandler, scanner);
                    break;
                case 3:
                    displaySearchMenu(systemData, propertyHandler, bookingHandler, scanner);
                    break;
                case 4:
                    displayBookingMenu(systemData, bookingHandler, scanner);
                case 5:
                    active = false;
                    break;
            }
        }

        System.out.println(systemData.getStudents());
        System.out.println(systemData.getHomeowners());
        System.out.println(systemData.getProperties());
        System.out.println(systemData.getBookings());
    }

    public static void displayMainMenu() {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Welcome to StudentRentals!");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Please select one of the following:");
        System.out.println("1. Register an account");
        System.out.println("2. Manage a property");
        System.out.println("3. Search for a room");
        System.out.println("4. Manage bookings");
        System.out.println("5. Exit");
        System.out.println(">> ");
    }

    public static void displayRegistrationMenu(SystemData systemData, Registration registration, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Registration Menu");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Please select one of the following:");
        System.out.println("1. Register as a Student");
        System.out.println("2. Register as a Homeowner");
        System.out.println("3. Login as a Student");
        System.out.println("4. Login as a Homeowner");
        System.out.println("5. Exit");
        System.out.println(">> ");
        int registerChoice = scanner.nextInt();

        switch (registerChoice) {
            case 1:
                startStudentRegistration(registration, scanner);
                break;
            case 2:
                startHomeownerRegistration(registration, scanner);
                break;
            case 3:
                startLoginStudent(systemData, registration, scanner);
                break;
            case 4:
                startLoginHomeowner(systemData, registration, scanner);
                break;
            case 5:
                break;
        }
        return;
    }

    public static void startStudentRegistration(Registration registration, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Student Registration Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter your name:");
        System.out.println(">> ");
        String name = scanner.next();
        System.out.println("Enter your email:");
        System.out.println(">> ");
        String email = scanner.next();
        System.out.println("Enter your password:");
        System.out.println(">> ");
        String password = scanner.next();
        System.out.println("Enter your student id:");
        System.out.println(">> ");
        String studentId = scanner.next();
        System.out.println("Enter your university:");
        System.out.println(">> ");
        String university = scanner.next();

        registration.registerStudent(name, email, password, studentId, university);
        return;
    }

    public static void startHomeownerRegistration(Registration registration, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Homeowner Registration Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter your name:");
        System.out.println(">> ");
        String name = scanner.next();
        System.out.println("Enter your email:");
        System.out.println(">> ");
        String email = scanner.next();
        System.out.println("Enter your password:");
        System.out.println(">> ");
        String password = scanner.next();

        registration.registerHomeowner(name, email, password, null);
        return;
    }

    public static void startLoginStudent(SystemData systemData, Registration registration, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Student Login Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println(">> ");
        System.out.println("Enter your email:");
        System.out.println(">> ");
        String email = scanner.next();
        System.out.println("Enter your password:");
        System.out.println(">> ");
        String password = scanner.next();

        Student student = registration.loginStudent(email, password);

        if (student == null) {
            return;
        }

        systemData.setCurrentStudent(student);
        System.out.println("Welcome " + systemData.getCurrentStudent().getName());
        return;
    }

    public static void startLoginHomeowner(SystemData systemData, Registration registration, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Homeowner Login Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter your email:");
        System.out.println(">> ");
        String email = scanner.next();
        System.out.println("Enter your password:");
        System.out.println(">> ");
        String password = scanner.next();

        Homeowner homeowner = registration.loginHomeowner(email, password);

        if (homeowner == null) {
            return;
        }

        systemData.setCurrentHomeowner(homeowner);
        System.out.println("Welcome " + systemData.getCurrentHomeowner().getName());
        return;
    }

    public static void displayPropertyMenu(SystemData systemData, PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Property Menu");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Please select one of the following:");
        System.out.println("1. View a property");
        System.out.println("2. List a property");
        System.out.println("3. Update a property");
        System.out.println("4. Remove a property");
        System.out.println("5. Exit");
        System.out.println(">> ");
        int propertyChoice = scanner.nextInt();

        switch (propertyChoice) {
            case 1:
                startPropertyView(propertyHandler, scanner);
                break;
            case 2:
                startPropertyListing(systemData, propertyHandler, scanner);
                break;
            case 3:
                displayPropertyUpdateMenu(propertyHandler, scanner);
                break;
            case 4:
                startPropertyDeletion(propertyHandler, scanner);
                break;
            case 5:
                break;
        }
        return;
    }

    public static void displayPropertyUpdateMenu(PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Update Property");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Please select one of the following:");
        System.out.println("1. Update status");
        System.out.println("2. Create a room");
        System.out.println("3. Delete a room");
        System.out.println("4. Exit");
        System.out.println(">> ");
        int propertyUpdateChoice = scanner.nextInt();

        switch (propertyUpdateChoice) {
            case 1:
                break;
            case 2:
                startRoomCreation(propertyHandler, scanner);
                break;
            case 3:
                startRoomDeletion(propertyHandler, scanner);
                break;
            case 4:
                break;
        }
        return;
    }

    public static void startPropertyView(PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Property Viewing Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter property address:");
        System.out.println(">> ");
        String address = scanner.next();

        if (!propertyHandler.doesPropertyExists(address)) {
            System.out.println("Property does not exist.");
            return;
        }

        Property property = propertyHandler.getPropertyFromAddress(address);
        System.out.println("Property address: " + property.getAddress());
        System.out.println("Property description: " + property.getDescription());
        return;
    }

    public static void startPropertyListing(SystemData systemData, PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Property Listing Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter property address:");
        System.out.println(">> ");
        String address = scanner.next();
        System.out.println("Enter property city:");
        System.out.println(">> ");
        String city = scanner.next();
        System.out.println("Enter property description:");
        System.out.println(">> ");
        String description = scanner.next();

        propertyHandler.listProperty(address, city, systemData.getCurrentHomeowner(), description);
        return;
    }

    public static void startPropertyDeletion(PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Property Deletion Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter property address:");
        System.out.println(">> ");
        String address = scanner.next();

        if (!propertyHandler.doesPropertyExists(address)) {
            System.out.println("Property does not exist.");
            return;
        }

        Property property = propertyHandler.getPropertyFromAddress(address);
        propertyHandler.deleteProperty(property);
        return;
    }

    public static void startRoomCreation(PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Room Creation Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter property address:");
        System.out.println(">> ");
        String address = scanner.next();
        System.out.println("Enter room type:");
        System.out.println(">> ");
        String roomType = scanner.next();
        System.out.println("Enter monthly rent:");
        System.out.println(">> ");
        Float monthlyRent = scanner.nextFloat();
        System.out.println("Enter description:");
        System.out.println(">> ");
        String description = scanner.next();
        System.out.println("Enter start date (YYYY-MM-DD):");
        System.out.println(">> ");
        String startDate = scanner.next();
        System.out.println("Enter end date (YYYY-MM-DD):");
        System.out.println(">> ");
        String endDate = scanner.next();

        if (!propertyHandler.doesPropertyExists(address)) {
            System.out.println("Property does not exist.");
            return;
        }

        Property property = propertyHandler.getPropertyFromAddress(address);
        propertyHandler.createRoom(property, roomType, monthlyRent, description, description, startDate, endDate);
        return;
    }

    public static void startRoomDeletion(PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Room Deletion Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter property address:");
        System.out.println(">> ");
        String address = scanner.next();

        if (!propertyHandler.doesPropertyExists(address)) {
            System.out.println("Property does not exist.");
            return;
        }

        Property property = propertyHandler.getPropertyFromAddress(address);

        if (property.isEmpty()) {
            System.out.println("Property has no rooms.");
            return;
        }

        List<Room> rooms = property.getRooms();
        int iterationId = 1;

        for (Room room : rooms) {
            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Room " + iterationId);
            System.out.println("Room type: " + room.getRoomType());
            System.out.println("Description: " + room.getDescription());
            System.out.println("-=-=-=-=-=-=-=-=-=-=-");
            iterationId++;
        }

        System.out.println("Please select a room from above to delete:");
        System.out.println(">> ");
        int roomToDelete = scanner.nextInt();

        rooms.remove(roomToDelete - 1);
        return;
    }

    public static void displaySearchMenu(SystemData systemData, PropertyHandler propertyHandler,
            BookingHandler bookingHandler, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Property Search Menu");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("1. View all rooms");
        System.out.println("2. Filter room by criteria");
        System.out.println("3. Exit");
        System.out.println(">> ");
        int searchChoice = scanner.nextInt();

        switch (searchChoice) {
            case 1:
                startGlobalSearch(propertyHandler, scanner);
                break;
            case 2:
                startFilterSearch(systemData, propertyHandler, bookingHandler, scanner);
                break;
            case 3:
                break;
        }
        return;
    }

    public static void startGlobalSearch(PropertyHandler propertyHandler, Scanner scanner) {
        return;
    }

    public static void startFilterSearch(SystemData systemData, PropertyHandler propertyHandler,
            BookingHandler bookingHandler,
            Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Room Filter Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Enter city or university area:");
        System.out.println(">> ");
        String city = scanner.next();

        List<Property> properties = propertyHandler.getPropertiesByCity(city);
        List<Room> filteredRooms = new ArrayList<>();
        int iterationId = 1;

        for (Property property : properties) {
            for (Room room : property.getRooms()) {
                System.out.println("\n-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("Room " + iterationId);
                System.out.println("Property address: " + property.getAddress());
                System.out.println("Room type: " + room.getRoomType());
                System.out.println("Monthly rent: " + room.getMonthlyRent());
                System.out.println("Description: " + room.getDescription());
                System.out.println("Status: " + room.getStatus());
                System.out.println("Start date: " + room.getStartDate());
                System.out.println("End date: " + room.getEndDate());
                System.out.println("-=-=-=-=-=-=-=-=-=-=-");
                filteredRooms.add(room);
                iterationId++;
            }
        }

        System.out.println("Please select a room from above to book:");
        System.out.println(">> ");
        int roomToBook = scanner.nextInt();
        Room room = filteredRooms.get(roomToBook - 1);
        bookingHandler.createBooking(systemData.getCurrentStudent(), room, "Pending", room.getStartDate(),
                room.getEndDate());
        return;
    }

    public static void displayBookingMenu(SystemData systemData, BookingHandler bookingHandler, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Booking Menu");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Please select one of the following:");
        System.out.println("1. View bookings");
        System.out.println("2. Cancel a booking");
        System.out.println("3. Booking dashboard (homeowners)");
        System.out.println("4. Exit");
        System.out.println(">> ");
        int bookingChoice = scanner.nextInt();

        switch (bookingChoice) {
            case 1:
                startBookingView(systemData, bookingHandler, scanner);
            case 2:
                cancelBookingView(systemData, bookingHandler, scanner);
            case 3:
                startBookingDashboardView(systemData, bookingHandler, scanner);
            case 4:
                break;
        }
        return;
    }

    public static void startBookingView(SystemData systemData, BookingHandler bookingHandler, Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Bookings View Page");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        List<Booking> bookings = bookingHandler.getBookingsByEmail(systemData.getCurrentStudent().getEmail());

        for (Booking booking : bookings) {
            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Student " + booking.getStudent().getName());
            System.out.println("Room: " + booking.getRoom().getRoomType());
            System.out.println("Status: " + booking.getStatus());
            System.out.println("Start date: " + booking.getStartDate());
            System.out.println("End date: " + booking.getEndDate());
            System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        }
        return;
    }

    public static void cancelBookingView(SystemData systemData, BookingHandler bookingHandler, Scanner scanner) {
    }

    public static void startBookingDashboardView(SystemData systemData, BookingHandler bookingHandler,
            Scanner scanner) {
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Booking Dashboard Page");
        Homeowner homeowner = systemData.getCurrentHomeowner();
        List<Booking> bookings = bookingHandler.getBookingsByOwner(homeowner);

        for (Booking booking : bookings) {
            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Student " + booking.getStudent());
            System.out.println("Room: " + booking.getRoom());
            System.out.println("Status: " + booking.getStatus());
            System.out.println("Start date: " + booking.getStartDate());
            System.out.println("End date: " + booking.getEndDate());
            System.out.println("-=-=-=-=-=-=-=-=-=-=-");

            if (booking.getStatus().equals("Pending")) {
                System.out.println("Do you accept or reject this booking?");
                System.out.println(">> ");
                String choice = scanner.next();

                if (choice.equals("accept")) {
                    booking.setStatus("Accepted");
                    booking.getRoom().setStatus("Occupied");
                } else if (choice.equals("reject")) {
                    booking.setStatus("Rejected");
                    booking.getRoom().setStatus("Occupied");
                }
            }
        }
        return;
    }
}
