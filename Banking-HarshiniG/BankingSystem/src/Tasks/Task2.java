package Tasks;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance;

        System.out.print("Enter current balance: ");
        balance = scanner.nextDouble();

        System.out.println("1. Check Balance\n2. Withdraw\n3. Deposit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Current Balance: $" + balance);
        } else if (choice == 2) {
            System.out.print("Enter amount to withdraw: ");
            double withdraw = scanner.nextDouble();

            if (withdraw <= balance) {
                if (withdraw % 100 == 0 || withdraw % 500 == 0) {
                    balance -= withdraw;
                    System.out.println("Withdrawal successful. New Balance: $" + balance);
                } else {
                    System.out.println("Withdrawal amount must be in multiples of 100 or 500.");
                }
            } else {
                System.out.println("Insufficient balance.");
            }
        } else if (choice == 3) {
            System.out.print("Enter amount to deposit: ");
            double deposit = scanner.nextDouble();
            balance += deposit;
            System.out.println("Deposit successful. New Balance: $" + balance);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
