package dao;

import entity.Account; 
import entity.Customer;

public interface IBankService extends ICustService { 
	Account createAccount(Customer customer, String accType, float balance); 
void listAccounts(); 
void calculateInterest(); 
}
 
	



