package dao;

public interface ICustService 
{ 
	float getAccountBalance(long accountNumber); 
	float deposit(long accountNumber, float amount); 
	float withdraw(long accountNumber, float amount) throws Exception; 
	void transfer(long fromAccountNumber, long toAccountNumber, float amount) throws Exception; 
	void getAccountDetails(long accountNumber); 
	}


