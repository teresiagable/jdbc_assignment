package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private static final String url = "jdbc:mysql://localhost:3306/world?autoReconnect=true&useSSL=false&serverTimezone=UTC";
	private static final String user = "root";
	private static final String passw = "root";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, passw);
	}
	 

}
