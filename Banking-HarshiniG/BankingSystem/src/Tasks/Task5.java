package Tasks;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Create a password: ");
        String password = scanner.next();

        boolean isValid = true;

        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters.");
            isValid = false;
        }

        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter.");
            isValid = false;
        }

        if (!password.matches(".*[0-9].*")) {
            System.out.println("Password must contain at least one digit.");
            isValid = false;
        }

        if (isValid) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }

        scanner.close();
    }
}

