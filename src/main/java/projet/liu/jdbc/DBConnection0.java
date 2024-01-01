package projet.liu.jdbc;

import java.sql.*; 

public class DBConnection0 { 
	private static DBConnection0 instance; 
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/Bibliophile";
	private String username = "root";
	private String password = "";

	private DBConnection0() throws SQLException { 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			this.connection = DriverManager.getConnection(url, username, password); 
			System.out.println("Connection etablie à la base de donnees"); 
		} catch (ClassNotFoundException e) { 
			System.out.println("Something is wrong with the DB connection String : " + e.getMessage()); 
		} 
	} 

	public Connection getConnection() { 
		return connection; 
	} 

	public static DBConnection0 getInstance() throws SQLException { 
		if (instance == null) { 
			instance = new DBConnection0(); 
		} else if (instance.getConnection().isClosed()) { 
			instance = new DBConnection0(); 
		} 
		return instance; 
	}
	
	public static void main(String [] args) {
		try {
			DBConnection0.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
