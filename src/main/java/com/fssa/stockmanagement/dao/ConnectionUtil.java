package com.fssa.stockmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getConnection() {

		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/investx";
		String userName = "root";
		String passWord = "123456";

		try {

			con = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connection successfull");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}
		return con;
	}
}
