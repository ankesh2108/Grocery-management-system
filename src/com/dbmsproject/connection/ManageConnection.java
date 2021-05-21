package com.dbmsproject.connection;

import com.mysql.jdbc.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;


public class ManageConnection {

	private static ManageConnection manageConnection;


	private static Connection connection;


	public ManageConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject?autoReconnect=true&useSSL=false", "root", "7887");
		} catch (Exception throwable) {
			System.out.println("Error :" + throwable.getMessage());
		}
	}


	public static ManageConnection createInstance() {

		if (manageConnection == null) {
			manageConnection = new ManageConnection();
		}
		return manageConnection;

	}


	public Connection getConnection() {
		if (connection != null)
			return connection;
		else
			return null;
	}


	public ResultSet executeQueryForResult(String query) {
		Statement st;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);

		} catch (SQLException throwable) {
			throwable.printStackTrace();
		}
		return rs;
	}


	public void executeUpdateQuery(String query) {
		Statement st;
		try {
			st = connection.createStatement();
			st.executeUpdate(query);

		} catch (SQLException throwable) {
			throwable.printStackTrace();
		}
	}


}

