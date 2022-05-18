package dao;

import model.BankingAcct;

public interface BankingAcctDao {
	
	// method to create a new account
	BankingAcct newAcct(BankingAcct bankingAcct);
	
	// method to add funds to an account
	BankingAcct depositFunds(BankingAcct bankingAcct, double acctChange);
	
	// method to remove funds from an account
	BankingAcct withdrawFunds(BankingAcct bankingAcct, double acctChange2);

	// method to view/print out account details
	BankingAcct viewBalance(BankingAcct bankingAcct);
}
