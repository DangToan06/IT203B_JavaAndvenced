package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBContext {
    private static final String NAME_DATABASE = "Rikkei_Hospital";
    private static final String NAME_USERNAME = "root";
    private static final String NAME_PASSWORD = "dangtoan2006";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + NAME_DATABASE;

    public  static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return  DriverManager.getConnection(CONNECTION_STRING, NAME_USERNAME, NAME_PASSWORD);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
