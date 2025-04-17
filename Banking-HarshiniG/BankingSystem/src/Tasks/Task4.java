package Tasks;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] accountNumbers = {101, 102, 103, 104};
        double[] balances = {1200.50, 3400.75, 560.00, 7890.00};

        boolean found = false;

        while (!found) {
            System.out.print("Enter your account number: ");
            int enteredAccount = scanner.nextInt();

            for (int i = 0; i < accountNumbers.length; i++) {
                if (enteredAccount == accountNumbers[i]) {
                    System.out.println("Your balance is: $" + balances[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Invalid account number. Please try again.");
            }
        }

        scanner.close();
    }
}


