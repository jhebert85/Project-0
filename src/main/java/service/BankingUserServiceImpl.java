package service;

import dao.BankingUserDao;
import dao.BankingUserDaoImpl;
import model.BankingUser;

public class BankingUserServiceImpl implements BankingUserService {

	BankingUserDao bankingUserDao;
	
	public BankingUserServiceImpl() {
		bankingUserDao = new BankingUserDaoImpl();
	}

	@Override
	public BankingUser createUser(BankingUser bankingUser) {
		return bankingUserDao.createUser(bankingUser);
	}

	@Override
	public BankingUser login(BankingUser bankingUser) {
		return bankingUserDao.login(bankingUser);
	}

	
}
