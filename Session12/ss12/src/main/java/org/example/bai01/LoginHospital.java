package org.example.bai01;

import org.example.database.DBContext;

import java.sql.*;

public class LoginHospital {
    public static void hospitalLogin(String username, String password) {
        String sql = "select * from Account where username = ? and password = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Đăng nhập thành công");
            }else {
                System.err.println("Tài khoản không tồn tại");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
