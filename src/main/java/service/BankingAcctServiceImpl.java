package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.BankingAcctDao;
import dao.BankingAcctDaoImpl;
import dao.BankingUserDaoImpl;
import dao.DBUtil;
import exception.EmptyStoreException;
import exception.SystemException;
import model.BankingAcct;

public class BankingAcctServiceImpl implements BankingAcctService {
	
	BankingAcctDao bankingAcctDao;
	
	public BankingAcctServiceImpl() {
		bankingAcctDao = new BankingAcctDaoImpl();
	}
	
	@Override
	public BankingAcct depositFunds(BankingAcct bankingAcct, double acctChange) {
		return bankingAcctDao.depositFunds(bankingAcct, acctChange);
	}

	@Override
	public BankingAcct withdrawFunds(BankingAcct bankingAcct, double acctChange2) {
		return bankingAcctDao.withdrawFunds(bankingAcct, acctChange2);
	}

	@Override
	public BankingAcct viewBalance(BankingAcct bankingAcct) {
		return bankingAcctDao.viewBalance(bankingAcct);
	}

	@Override
	public BankingAcct newAcct(BankingAcct bankingAcct) {
		return bankingAcctDao.newAcct(bankingAcct);
	}


}
