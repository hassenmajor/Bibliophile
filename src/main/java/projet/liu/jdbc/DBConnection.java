package projet.liu.jdbc;

import java.sql.*; 

public class DBConnection { 
	private static DBConnection instance; 
	private Connection connection;
	private String url = "jdbc:mysql:aws://database-1.clekqes8qfje.eu-west-3.rds.amazonaws.com:3306/Bibliophile";
	private String username = "admin";
	private String password = "El.199747";

	private DBConnection() throws SQLException { 
		try {
			Class.forName("software.aws.rds.jdbc.mysql.Driver"); 
			this.connection = DriverManager.getConnection(url, username, password); 
			System.out.println("Connection etablie à la base de donnees"); 
		} catch (ClassNotFoundException e) { 
			System.out.println("Something is wrong with the DB connection String : " + e.getMessage()); 
		} 
	} 

	public Connection getConnection() { 
		return connection; 
	} 

	public static DBConnection getInstance() throws SQLException { 
		if (instance == null) { 
			instance = new DBConnection(); 
		} else if (instance.getConnection().isClosed()) { 
			instance = new DBConnection(); 
		} 
		return instance; 
	}
	
	public static void main(String [] args) {
		try {
			DBConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
