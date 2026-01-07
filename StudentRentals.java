import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentRentals {
    public static void main(String[] args) {
        SystemData systemData = new SystemData();
        Registration registration = new Registration(systemData);
        PropertyHandler propertyHandler = new PropertyHandler(systemData);
        Scanner scanner = new Scanner(System.in);

        boolean active = true;
        while (active) {
            displayMainMenu();
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    displayRegistrationMenu(registration, scanner);
                    break;
                case 2:
                    displayPropertyMenu(propertyHandler, scanner);
                    break;
                case 3:
                    displaySearchMenu(propertyHandler, scanner);
                    break;
                case 4:
                    active = false;
                    break;
            }
        }

        System.out.println(systemData.getStudents());
        System.out.println(systemData.getHomeowners());
        System.out.println(systemData.getProperties());
    }

    public static void displayMainMenu() {
        System.out.println("Welcome to StudentRentals!");
        System.out.println("Please select one of the following:");
        System.out.println("1. Register an account");
        System.out.println("2. Manage a property");
        System.out.println("3. Search for a room");
        System.out.println("4. Exit");
    }

    public static void displayRegistrationMenu(Registration registration, Scanner scanner) {
        System.out.println("Registration Menu");
        System.out.println("Please select one of the following:");
        System.out.println("1. Register as a Student");
        System.out.println("2. Register as a Homeowner");
        System.out.println("3. Exit");
        int registerChoice = scanner.nextInt();

        switch (registerChoice) {
            case 1:
                startStudentRegistration(registration, scanner);
                break;
            case 2:
                startHomeownerRegistration(registration, scanner);
                break;
            case 3:
                break;
        }
        return;
    }

    public static void startStudentRegistration(Registration registration, Scanner scanner) {
        System.out.println("Student Registration Page");
        System.out.println("Enter your name:");
        String name = scanner.next();
        System.out.println("Enter your email:");
        String email = scanner.next();
        System.out.println("Enter your password:");
        String password = scanner.next();
        System.out.println("Enter your student id:");
        String studentId = scanner.next();
        System.out.println("Enter your university:");
        String university = scanner.next();

        if (!registration.isEmailUnique(email)) {
            System.out.println("Email already exists.");
            return;
        }

        registration.registerStudent(name, email, password, studentId, university);
        return;
    }

    public static void startHomeownerRegistration(Registration registration, Scanner scanner) {
        System.out.println("Homeowner Registration Page");
        System.out.println("Enter your name:");
        String name = scanner.next();
        System.out.println("Enter your email:");
        String email = scanner.next();
        System.out.println("Enter your password:");
        String password = scanner.next();

        if (!registration.isEmailUnique(email)) {
            System.out.println("Email already exists.");
            return;
        }

        registration.registerHomeowner(name, email, password, null);
        return;
    }

    public static void displayPropertyMenu(PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("Property Menu");
        System.out.println("Please select one of the following:");
        System.out.println("1. View a property");
        System.out.println("2. List a property");
        System.out.println("3. Update a property");
        System.out.println("4. Remove a property");
        System.out.println("5. Exit");
        int propertyChoice = scanner.nextInt();

        switch (propertyChoice) {
            case 1:
                startPropertyView(propertyHandler, scanner);
                break;
            case 2:
                startPropertyListing(propertyHandler, scanner);
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
        System.out.println("Update Property");
        System.out.println("Please select one of the following:");
        System.out.println("1. Update status");
        System.out.println("2. Create a room");
        System.out.println("3. Delete a room");
        System.out.println("4. Exit");
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
        System.out.println("Property Viewing Page");
        System.out.println("Enter property address:");
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

    public static void startPropertyListing(PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("Property Listing Page");
        System.out.println("Enter property address:");
        String address = scanner.next();
        System.out.println("Enter property city:");
        String city = scanner.next();
        System.out.println("Enter property description:");
        String description = scanner.next();

        propertyHandler.listProperty(address, city, description);
        return;
    }

    public static void startPropertyDeletion(PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("Property Deletion Page");
        System.out.println("Enter property address:");
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
        System.out.println("Room Creation Page");
        System.out.println("Enter property address:");
        String address = scanner.next();
        System.out.println("Enter room type:");
        String roomType = scanner.next();
        System.out.println("Enter monthly rent:");
        Float monthlyRent = scanner.nextFloat();
        System.out.println("Enter description:");
        String description = scanner.next();
        System.out.println("Enter start date (YYYY-MM-DD):");
        String startDate = scanner.next();
        System.out.println("Enter end date (YYYY-MM-DD):");
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
        System.out.println("Room Deletion Page");
        System.out.println("Enter property address:");
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
            System.out.println("Room " + iterationId);
            System.out.println("Room type: " + room.getRoomType());
            System.out.println("Description: " + room.getDescription());
            iterationId++;
        }

        System.out.println("Please select a room from above to delete:");
        int roomToDelete = scanner.nextInt();

        rooms.remove(roomToDelete - 1);
        return;
    }

    public static void displaySearchMenu(PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("Property Search Menu");
        System.out.println("1. View all rooms");
        System.out.println("2. Filter room by criteria");
        System.out.println("3. Exit");
        int searchChoice = scanner.nextInt();

        switch (searchChoice) {
            case 1:
                startGlobalSearch(propertyHandler, scanner);
                break;
            case 2:
                startFilterSearch(propertyHandler, scanner);
                break;
            case 3:
                break;
        }
        return;
    }

    public static void startGlobalSearch(PropertyHandler propertyHandler, Scanner scanner) {
        return;
    }

    public static void startFilterSearch(PropertyHandler propertyHandler, Scanner scanner) {
        System.out.println("Room Filter Page");
        System.out.println("Enter city or university area:");
        String city = scanner.next();

        List<Property> properties = propertyHandler.getPropertiesByCity(city);

        for (Property property : properties) {
            for (Room room : property.getRooms()) {
                System.out.println("Property address: " + property.getAddress());
                System.out.println("Room type: " + room.getRoomType());
                System.out.println("Monthly rent: " + room.getMonthlyRent());
                System.out.println("Description: " + room.getDescription());
                System.out.println("Status: " + room.getStatus());
                System.out.println("Start date: " + room.getStartDate());
                System.out.println("End date: " + room.getEndDate());
            }
        }
        return;
    }
}
