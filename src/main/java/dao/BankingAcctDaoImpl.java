package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.EmptyStoreException;
import exception.SystemException;
import model.BankingAcct;
import model.BankingUser;

public class BankingAcctDaoImpl implements BankingAcctDao {

	@Override
	public BankingAcct newAcct(BankingAcct bankingAcct) {
		Connection conn = null;

		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO bankingacct(user_num, acct_type, acct_balance) VALUES('"+bankingAcct.getUser_num()+"','Checking', 0) returning acct_num";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				bankingAcct.setAcct_num(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankingAcct;
	}

	@Override
	public BankingAcct depositFunds(BankingAcct bankingAcct, double acctChange) {

		Connection conn = null;

		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT acct_num FROM bankingacct WHERE user_num="+bankingAcct.getUser_num()+"";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				bankingAcct.setAcct_num(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			Statement stmt2 = conn.createStatement();
			String query2 = "SELECT acct_balance FROM bankingacct WHERE user_num=" + bankingAcct.getUser_num() +"";
			ResultSet rs2 = stmt2.executeQuery(query2);
			
			if(rs2.next()) {
				double acctBalance = rs2.getDouble(1);
				double acctUpdated = acctBalance + acctChange;
				Statement stmt3 = conn.createStatement();
				String query3 = "UPDATE bankingAcct SET acct_balance= " + (acctUpdated) + " WHERE acct_num= " + bankingAcct.getAcct_num();
				int updatedBalance = stmt3.executeUpdate(query3);
				
				System.out.println("Deposit of $" + acctChange +" Was Successful.");
				System.out.println("   Your New Balance Is $" + acctUpdated);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankingAcct;
	}

	@Override
	public BankingAcct withdrawFunds(BankingAcct bankingAcct, double acctChange2) {
		Connection conn = null;

		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT acct_num FROM bankingacct WHERE user_num="+bankingAcct.getUser_num()+"";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				bankingAcct.setAcct_num(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			Statement stmt2 = conn.createStatement();
			String query2 = "SELECT acct_balance FROM bankingacct WHERE user_num=" + bankingAcct.getUser_num() +"";
			ResultSet rs2 = stmt2.executeQuery(query2);
			
			if(rs2.next()) {
				double acctBalance2 = rs2.getDouble(1);
				double acctUpdated2 = acctBalance2 - acctChange2;
				Statement stmt3 = conn.createStatement();
				String query3 = "UPDATE bankingAcct SET acct_balance= " + (acctUpdated2) + " WHERE acct_num= " + bankingAcct.getAcct_num();
				int updatedBalance2 = stmt3.executeUpdate(query3);
				
				System.out.println("Withdraw of $" + acctChange2 +" Was Successful.");
				System.out.println("   Your New Balance Is $" + acctUpdated2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankingAcct;
	}

	@Override
	public BankingAcct viewBalance(BankingAcct bankingAcct) {

		Connection conn = null;
		bankingAcct = null;

		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM bankingacct WHERE acct_num=" + bankingAcct.getAcct_num();
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				bankingAcct = new BankingAcct(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankingAcct;
	}
	
}
