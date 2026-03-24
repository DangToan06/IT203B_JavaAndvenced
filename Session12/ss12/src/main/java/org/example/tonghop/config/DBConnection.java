package org.example.tonghop.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/HospitalManagement";
    private static final String USER = "root";
    private static final String PASS = "dangtoan2006";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}