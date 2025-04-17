package Tasks;

import java.util.ArrayList;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> transactions = new ArrayList<>();

        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("\nChoose an option: 1. Deposit 2. Withdraw 3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double deposit = scanner.nextDouble();
                    transactions.add("Deposited: $" + deposit);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = scanner.nextDouble();
                    transactions.add("Withdrew: $" + withdraw);
                    break;
                case 3:
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("\nTransaction History:");
        for (String t : transactions) {
            System.out.println(t);
        }

        scanner.close();
    }
}

