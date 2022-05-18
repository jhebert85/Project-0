package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.EmptyStoreException;
import model.BankingAcct;
import model.BankingUser;

public class BankingUserDaoImpl implements BankingUserDao {

	@Override
	public BankingUser createUser(BankingUser bankingUser) {

		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO bankinguser(fname, lname, address, zip, phone, dob, userName, password)"
					+ "VALUES('" + bankingUser.getFname() + "', '" + bankingUser.getLname() + "', '"
					+ bankingUser.getAddress() + "', '" + bankingUser.getZip() + "', '" + bankingUser.getPhone()
					+ "', '" + bankingUser.getDob() + "','" + bankingUser.getUserName() + "','" + bankingUser.getPassword() + "') returning user_num";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			bankingUser.setUser_num(rs.getInt("user_num"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankingUser;
	}

	@Override
	public BankingUser login(BankingUser bankingUser) {
		
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from bankinguser where username = '"+ bankingUser.getUserName() +"' and password = '"+bankingUser.getPassword()+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				bankingUser.setUser_num(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankingUser;
	}

}
