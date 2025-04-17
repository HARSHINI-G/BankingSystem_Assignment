package Tasks;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int numCustomers = scanner.nextInt();

        for (int i = 1; i <= numCustomers; i++) {
            System.out.println("\nCustomer " + i);
            System.out.print("Initial Balance: ");
            double balance = scanner.nextDouble();

            System.out.print("Annual Interest Rate (%): ");
            double rate = scanner.nextDouble();

            System.out.print("Number of Years: ");
            int years = scanner.nextInt();

            double futureBalance = balance * Math.pow((1 + rate / 100), years);
            System.out.printf("Future Balance after %d years: $%.2f\n", years, futureBalance);
        }

        scanner.close();
    }
}

