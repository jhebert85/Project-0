package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// singleton design pattern
	static Connection conn;
		
	static {
		try {
			//step 1
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Connection makeConnection() throws SQLException {
		//step 2
		String connectionUrl = "jdbc:postgresql://localhost:5432/bankingapp";
		String userName = "postgres";
		String password = "Lsumed85!!";
		
//		String connectionUrl = "jdbc:postgresql://project0.cj8tiqahvmjj.us-east-1.rds.amazonaws.com:5432/Project-0";
//		String userName = "jhebert";
//		String password = "SoftDev2022!!";
		if(conn == null) {
			conn = DriverManager.getConnection(connectionUrl, userName, password);	
		}
		return conn;
	}
	

}
