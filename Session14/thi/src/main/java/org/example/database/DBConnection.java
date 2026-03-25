package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String DATABASE_NAME = "ktraDauh_db";
    private static String USERNAME = "root";
    private static String PASSWORD = "dangtoan2006";
    private static String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
