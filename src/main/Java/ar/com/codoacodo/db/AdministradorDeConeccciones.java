package ar.com.codoacodo.db;

import java.sql.Connection;

import java.sql.DriverManager;

public class AdministradorDeConeccciones {
	
	public static Connection getConnection() {
		String hosts = "127.0.0.1";/
		String port = "3306";
		String password = "root";
		String username = "root";
		
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		String dbName = "22569";
		
		Connection connection;
		try {
			Class.forName(driverClassName);
			
			String url = "jdbc:mysql://" + hosts + ":"+ port +"/"+ dbName +"?serverTimeZone=UTC&useSSL=false";
			
			connection = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			connection = null;
		}
		
		return connection;
	}
}
