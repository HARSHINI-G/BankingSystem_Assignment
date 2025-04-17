package dao;

import java.sql.SQLException;

import Exception.AccNotFound;
import Exception.InvalidAcc;

public interface ICustService 
{ 
	float getAccountBalance(long accountNumber) throws AccNotFound, SQLException, InvalidAcc; 
	float deposit(long accountNumber, float amount) throws Exception; 
	float withdraw(long accountNumber, float amount) throws Exception; 
	void transfer(long fromAccountNumber, long toAccountNumber, float amount) throws Exception; 
	void getAccountDetails(long accountNumber) throws Exception; 
	}


