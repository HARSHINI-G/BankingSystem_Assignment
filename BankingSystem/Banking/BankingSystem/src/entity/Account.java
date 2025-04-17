package entity;

public class Account {
	private static long lastAccNo = 1000; 
	protected long accountNumber; 
	protected String accountType; 
	protected float balance; 
	protected Customer customer;
	public Account() {
	    this.accountNumber = ++lastAccNo;
	}

	public Account(String accountType, float balance, Customer customer) {
	    this.accountNumber = ++lastAccNo;
	    this.accountType = accountType;
	    this.balance = balance;
	    this.customer = customer;
	}

	public long getAccountNumber() {
	    return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
	    this.accountNumber = accountNumber;
	}

	public String getAccountType() {
	    return accountType;
	}

	public void setAccountType(String accountType) {
	    this.accountType = accountType;
	}

	public float getBalance() {
	    return balance;
	}

	public void setBalance(float balance) {
	    this.balance = balance;
	}

	public Customer getCustomer() {
	    return customer;
	}

	public void setCustomer(Customer customer) {
	    this.customer = customer;
	}

	public void deposit(float amount) {
	    if (amount > 0) {
	        balance += amount;
	        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
	    } else {
	        System.out.println("Invalid deposit amount");
	    }
	}

	public void withdraw(float amount) throws Exception {
	    if (amount > 0 && balance >= amount) {
	        balance -= amount;
	        System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
	    } else {
	        throw new Exception("Insufficient Balance or Invalid amount!");
	    }
	}

	public void displayAccountInfo() {
	    System.out.println("Account Number: " + accountNumber);
	    System.out.println("Account Type: " + accountType);
	    System.out.println("Balance: " + balance);
	}

	}

