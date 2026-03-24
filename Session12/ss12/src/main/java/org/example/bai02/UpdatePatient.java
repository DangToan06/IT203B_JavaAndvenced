package org.example.bai02;

import org.example.database.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePatient {
    public static void update(String idPatient, double temperature, int heartRate ){
        String sql = "UPDATE Patients SET Temperature = ?, HeartRate = ? WHERE patients.ID_Patients = ?;";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setDouble(1, temperature);
            pstmt.setInt(2, heartRate);
            pstmt.setString(3, idPatient);

            int rs = pstmt.executeUpdate();

            if (rs>0){
                System.out.println("Cập nhật bện nhân có id " +  idPatient + " thành công");
            }else {
                System.err.println("Cập nhận thất bại");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
