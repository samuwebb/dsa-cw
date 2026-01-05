import java.util.Scanner;

public class StudentRentals {
    public static void main(String[] args) {
        SystemData systemData = new SystemData();
        Registration registration = new Registration();
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
                    active = false;
                    break;
            }
        }
    }

    public static void displayMainMenu() {
        System.out.println("Welcome to StudentRentals!");
        System.out.println("Please select one of the following:");
        System.out.println("1. Register");
        System.out.println("2. Exit");
    }

    public static void displayRegistrationMenu(Registration registration, Scanner scanner) {
        System.out.println("Registration Menu");
        System.out.println("Please select one of the following:");
        System.out.println("1. Register as a Student");
        System.out.println("2. Register as a Homeowner");
        int registerChoice = scanner.nextInt();

        switch (registerChoice) {
            case 1:
                startStudentRegistration(registration, scanner);
            case 2:
                startHomeownerRegistration(registration, scanner);
            case 3:
                return;
        }
    }

    public static void startStudentRegistration(Registration registration, Scanner scanner) {
        System.out.println("Student Registration Page");
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        System.out.println("Enter your student id:");
        String studentId = scanner.nextLine();
        System.out.println("Enter your university:");
        String university = scanner.nextLine();

        registration.registerStudent("0", name, email, password, studentId, university);
        return;
    }

    public static void startHomeownerRegistration(Registration registration, Scanner scanner) {
        System.out.println("Homeowner Registration Page");
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        registration.registerHomeowner(password, name, email, password, null);
        return;
    }
}
