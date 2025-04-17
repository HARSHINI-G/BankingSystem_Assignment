package entity;

public class SavingsAcc extends Account { 
	private final float interestRate = 4.5f; 
	public SavingsAcc(float balance, Customer customer) {
	    super("Savings", balance >= 500 ? balance : 500, customer);
	}

	public float getInterestRate() {
	    return interestRate;
	}

	public void calculateInterest() {
	    float interest = (balance * interestRate) / 100;
	    balance += interest;
	    System.out.println("Interest added: " + interest + ", New Balance: " + balance);
	}

	}

