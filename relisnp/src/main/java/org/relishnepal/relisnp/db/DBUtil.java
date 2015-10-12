package org.relishnepal.relisnp.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String M_CONN_STRING = "jdbc:mysql://localhost/dbname";

	
	public static Connection getConnection(DBType dbType) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		switch (dbType) {
		case MYSQL:
			return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
		
		default:
			return null;
			
		}
	}
	
	public static void processException(SQLException e){
		System.err.println("Error message: " + e.getMessage());
		System.err.println("Error code: " + e.getErrorCode());
		System.err.println("SQL state: " + e.getSQLState());
		
	}
}
