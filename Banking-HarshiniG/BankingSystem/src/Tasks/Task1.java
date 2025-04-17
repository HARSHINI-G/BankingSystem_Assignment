package Tasks;

import java.util.Scanner;

public class Task1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Credit Score: ");
        int creditScore = scanner.nextInt();

        System.out.print("Enter Annual Income: ");
        double income = scanner.nextDouble();

        if (creditScore > 700 && income >= 50000) {
            System.out.println("Eligible for a loan.");
        } else {
            System.out.println("Not eligible for a loan.");
        }
        scanner.close();
    }
}

