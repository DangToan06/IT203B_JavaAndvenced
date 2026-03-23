package org.example.bai04;

import org.example.bai01.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeatSystem {
    public static void searchPatient(String patientName) {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Patient WHERE NamePatient = ?";

        try {
            conn =db.getHospitalConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, patientName);

            rs = pstmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                String id = rs.getString("Id");
                String name = rs.getString("NamePatient");

                System.out.println("Bệnh Nhân tìm được là:");
                System.out.printf("%-10s %-30s\n",  id, name);
                count++;
            }

            if (count == 0){
                System.err.println("Không có bệnh nhân nào tên như vậy");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
