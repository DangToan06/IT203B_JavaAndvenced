package org.example.bai02;

import org.example.bai01.DBContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PharmacyCatalogue {
    public static void printAllMedicines() {
        DBContext db = new DBContext();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.getHospitalConn();
            String sql = "SELECT Id, PharmacyName FROM Pharmacy";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("--- DANH MỤC THUỐC KIỂM KÊ ---");
            System.out.printf("%-20s | %-10s\n", "ID thuốc", "Tên thuốc");
            System.out.println("------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String id = rs.getString("Id");
                String name = rs.getString("PharmacyName");

                System.out.printf("%-20s | %-10s\n", id, name);
                count++;
            }

            if (count == 0) {
                System.out.println("Thông báo: Kho thuốc hiện đang trống.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
