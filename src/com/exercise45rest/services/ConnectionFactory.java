package com.exercise45rest.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	//Declare my properties objects
	static Properties props = new Properties();
	static InputStream in = null;
	
	//Declare my credential variables
	static String driver="";
	static String urlServer="";
	static String username="";
	static String password="";
	
	//Step 2. Instance of the class must be private and static
	private static ConnectionFactory connection=null;
	private static Connection conn = null;
	
	public static Connection getConnection()
	{
		in = connection.getClass().getClassLoader().getResourceAsStream("dao.properties");
		try {
			props.load(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(props!=null)
		{
			driver = props.getProperty("driver");
			urlServer = props.getProperty("urlServer");
			username = props.getProperty("username");
			password = props.getProperty("password");
		}
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(urlServer, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//Singleton Design Pattern
	//Step 1. Private constructor
	private void ConnectionFactory()
	{
	}
	
	//Step 3. Create getInstance method
	public static ConnectionFactory getInstance()
	{
		if(connection == null)
		{
			connection = new ConnectionFactory();
		}
		return connection;
	}
}
