package dao;

import entity.Account;
import exception.InvalidAcc;
import java.util.HashMap;
import java.util.Map;


public class CustServiceImpl implements ICustService {

	protected Map<Long, Account> accounts = new HashMap<>();

	@Override
	public float getAccountBalance(long accountNumber) {
	    Account acc = accounts.get(accountNumber);
	    return (acc != null) ? acc.getBalance() : 0f;
	}

	@Override
	public float deposit(long accountNumber, float amount) {
	    Account acc = accounts.get(accountNumber);
	    if (acc != null) {
	        acc.deposit(amount);
	        return acc.getBalance();
	    }
	    return 0f;
	}

	@Override
	public float withdraw(long accountNumber, float amount) throws Exception {
	    Account acc = accounts.get(accountNumber);
	    if (acc != null) {
	        acc.withdraw(amount);
	        return acc.getBalance();
	    } else {
	        throw new InvalidAcc("Account not found");
	    }
	}

	@Override
	public void transfer(long fromAccountNumber, long toAccountNumber, float amount) throws Exception {
	    Account from = accounts.get(fromAccountNumber);
	    Account to = accounts.get(toAccountNumber);

	    if (from == null || to == null) {
	        throw new InvalidAcc("accounts not found.");
	    }

	    from.withdraw(amount);
	    to.deposit(amount);
	}

	@Override
	public void getAccountDetails(long accountNumber) {
	    Account acc = accounts.get(accountNumber);
	    if (acc != null) {
	        acc.displayAccountInfo();
	        acc.getCustomer().displayCustomerInfo();
	    } else {
	        System.out.println("Account not found.");
	    }
	}

	}

