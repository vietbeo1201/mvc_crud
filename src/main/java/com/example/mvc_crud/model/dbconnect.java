package com.example.mvc_crud.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {
    private static String url = "jdbc:mysql://localhost:3306/demo_users";
    private static String username = "root";
    private static String password = "123456@Abc";

    dbconnect (){

    }

    public static Connection getconnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
