package dao;

import entity.*;
import java.util.ArrayList;
import java.util.List;


public class BankServiceImpl  extends CustServiceImpl implements IBankService {
	private final List<Account> accountList = new ArrayList<>();

	@Override
	public Account createAccount(Customer customer, String accType, float balance) {
	    Account acc;
	    switch (accType.toLowerCase()) {
	        case "savings":
	            acc = new SavingsAcc(balance, customer);
	            break;
	        case "current":
	            acc = new CurrentAcc(balance, customer);
	            break;
	        case "zerobalance":
	            acc = new ZeroBalanceAcc(customer);
	            break;
	        default:
	            System.out.println("Invalid account type!");
	            return null;
	    }

	    accounts.put(acc.getAccountNumber(), acc);
	    accountList.add(acc);
	    System.out.println("Account created with number: " + acc.getAccountNumber());
	    return acc;
	}

	@Override
	public void listAccounts() {
	    for (Account acc : accountList) {
	        acc.displayAccountInfo();
	        acc.getCustomer().displayCustomerInfo();
	    }
	}

	@Override
	public void calculateInterest() {
	    for (Account acc : accountList) {
	        if (acc instanceof SavingsAcc) {
	            ((SavingsAcc) acc).calculateInterest();
	        }
	    }
	}

	}

