package dao;

import Entity.Account; 
import Entity.Customer;

public interface IBankService extends ICustService { 
	Account createAccount(Customer customer, String accType, float balance); 
void listAccounts(); 
void calculateInterest(); 
}
 
	



