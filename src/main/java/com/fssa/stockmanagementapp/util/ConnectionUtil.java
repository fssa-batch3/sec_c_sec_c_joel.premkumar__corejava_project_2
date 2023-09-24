package com.fssa.stockmanagementapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionUtil {


    public static Connection getConnection() {
        Connection con = null;

        String url, userName, passWord;

            url = System.getenv("DATABASE_HOST_LOCAL");
            userName = System.getenv("DATABASE_USERNAME_LOCAL");
            passWord = System.getenv("DATABASE_PASSWORD_LOCAL");
            

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, passWord);
            System.out.println("connection is successful");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database");
        }
        return con; 


    }

    private ConnectionUtil() {


    }

    public static void main(String[] args) {
        Connection con = getConnection();
    }
}