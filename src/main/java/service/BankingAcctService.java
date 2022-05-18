package service;

import java.util.List;

import exception.EmptyStoreException;
import exception.SystemException;
import model.BankingAcct;

public interface BankingAcctService {
	
	BankingAcct newAcct(BankingAcct bankingAcct);
	
	BankingAcct depositFunds(BankingAcct bankingAcct, double acctChange);
	
	BankingAcct withdrawFunds(BankingAcct bankingAcct, double acctChange2);
	
	BankingAcct viewBalance(BankingAcct bankingAcct);
	
}
