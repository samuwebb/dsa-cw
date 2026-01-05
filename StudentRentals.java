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
                    displayRegistration(registration, scanner);
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

    public static void displayRegistration(Registration registration, Scanner scanner) {
        int registerChoice = scanner.nextInt();

        System.out.println("Registration page");
        System.out.println("Please select one of the following:");
        System.out.println("1. Register as a Student");
        System.out.println("2. Register as a Homeowner");

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
    }

    public static void startHomeownerRegistration(Registration registration, Scanner scanner) {
    }
}
