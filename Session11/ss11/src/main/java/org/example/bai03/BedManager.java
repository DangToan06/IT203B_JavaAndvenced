package org.example.bai03;

import org.example.bai01.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BedManager {
    public static void updateBedStatus(String bedId, String newStatus){
        DBContext db =  new DBContext();
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "UPDATE bed SET StatusBed=? WHERE Id=?";
        try{
            conn = db.getHospitalConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newStatus);
            pstmt.setString(2, bedId);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Thành công: Giường " + bedId + " đã chuyển sang trạng thái: " + newStatus);
            } else {
                System.err.println("Lỗi: Mã giường '" + bedId + "' không tồn tại. Vui lòng kiểm tra lại!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi hệ thống khi cập nhật: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
