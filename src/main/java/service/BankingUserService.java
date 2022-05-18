package service;

import model.BankingUser;

public interface BankingUserService {

	BankingUser createUser(BankingUser bankingUser);
	
	BankingUser login(BankingUser bankingUser);
	
}