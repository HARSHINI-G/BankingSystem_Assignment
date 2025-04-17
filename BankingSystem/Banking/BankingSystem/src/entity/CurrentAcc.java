package entity;

public class CurrentAcc extends Account { 
	private final float overdraftLimit = 2000; 
	

	public CurrentAcc(float balance, Customer customer) {
	    super("Current", balance, customer);
	}

	public float getOverdraftLimit() {
	    return overdraftLimit;
	}

	@Override
	public void withdraw(float amount) throws Exception {
	    if (amount > 0 && (balance + overdraftLimit) >= amount) {
	        balance -= amount;
	        System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
	    } else {
	        throw new Exception("Overdraft Limit Exceeded or Invalid amount!");
	    }
	}

	}
