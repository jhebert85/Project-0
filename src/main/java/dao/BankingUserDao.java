package dao;

import java.util.List;

import model.BankingUser;

public interface BankingUserDao {

	// method to create a user
	BankingUser createUser(BankingUser bankingUser);

	// method to login to an account 
	// include permissions
	BankingUser login(BankingUser bankinguser);
	
		
}

