package app;
import dao.BankServiceImpl;
import dao.IBankService;
import Entity.Customer;
import java.util.Scanner;


public class BankApp {
	public static void main(String[] args) { 
		IBankService bank = new BankServiceImpl(); 
		Scanner sc = new Scanner(System.in); 
		boolean ch = true;
while (ch) {
        System.out.println("\n******Bank Menu******");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Get Balance");
        System.out.println("6. Account Details");
        System.out.println("7. List all Accounts");
        System.out.println("8. Calculate Interest");
        System.out.println("9. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        try {
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("First Name: ");
                    String fname = sc.nextLine();
                    System.out.print("Last Name: ");
                    String lname = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Address: ");
                    String address = sc.nextLine();
                    System.out.print("Account Type (Savings/Current/ZeroBalance): ");
                    String accType = sc.nextLine();
                    System.out.print("Initial Balance: ");
                    float bal = sc.nextFloat();

                    Customer cust = new Customer(System.currentTimeMillis(), fname, lname, email, phone, address);
                    bank.createAccount(cust, accType, bal);
                    break;

                case 2:
                    System.out.print("Account Number: ");
                    long accNo1 = sc.nextLong();
                    System.out.print("Amount: ");
                    float dep = sc.nextFloat();
                    bank.deposit(accNo1, dep);
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    long accNo2 = sc.nextLong();
                    System.out.print("Amount: ");
                    float wd = sc.nextFloat();
                    bank.withdraw(accNo2, wd);
                    break;

                case 4:
                    System.out.print("From Account: ");
                    long fromAcc = sc.nextLong();
                    System.out.print("To Account: ");
                    long toAcc = sc.nextLong();
                    System.out.print("Amount: ");
                    float amt = sc.nextFloat();
                    bank.transfer(fromAcc, toAcc, amt);
                    break;

                case 5:
                    System.out.print("Account Number: ");
                    long accNo3 = sc.nextLong();
                    float balance = bank.getAccountBalance(accNo3);
                    System.out.println("Balance: " + balance);
                    break;

                case 6:
                    System.out.print("Account Number: ");
                    long accNo4 = sc.nextLong();
                    bank.getAccountDetails(accNo4);
                    break;

                case 7:
                    bank.listAccounts();
                    break;

                case 8:
                    bank.calculateInterest();
                    break;

                case 9:
                	System.out.println("Exit the application..");
                    ch = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    sc.close();
}

}
	
