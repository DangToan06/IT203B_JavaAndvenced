package org.example.dao;

import org.example.database.DBConnection;

import java.sql.*;

public class PaymentDAO {

    public static boolean check(String id){
        String sql = "SELECT * FROM Accounts WHERE idNguoiChuyen = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                System.out.println("Tìm thấy người chuyển");
                return  true;
            }else {
                System.out.println("Khong tim thay nguoi chuyen");
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void transaction ( String id, double balance ){
        String sql = "{call sp_UpdateBalance(?, ?)}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)){

            cstmt.setString(1, id);
            cstmt.setDouble(2, balance);
            cstmt.execute();

            System.out.println("Chuyển tiền thành công");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
