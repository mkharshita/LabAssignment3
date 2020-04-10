package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactory 
{
	static Connection con;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String path = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "MKHARSHITA";
		String password = "root123";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(path, username, password);
		return con;
	}
}
