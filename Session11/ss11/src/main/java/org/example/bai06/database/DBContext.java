package org.example.bai06.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private final static String DATABASE_NAME = "RikkeiCare_DB";
    private final static String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private final static String USERNAME = "root";
    private final static String PASSWORD = "dangtoan2006";

    public static Connection getHospitalConn() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return  DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (ClassNotFoundException e){
            System.err.println("Driver not found " + e.getMessage());
            return null;
        }
    }

    public static void testQuery() {
        Connection conn = null;
        try {
            conn = getHospitalConn();
            if (conn != null) {
                System.out.println("Kết nối thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("Đã đóng kết nối an toàn.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}