package org.example.tonghop.dao;

import org.example.tonghop.config.DBConnection;

import java.sql.*;

public class HospitalDAO {

    public void updateMedicineStock(int id, int addedQuantity) {
        String sql = "UPDATE medicines SET stock = stock + ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, addedQuantity);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();
            System.out.println("Đã cập nhật " + rows + " dòng.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findMedicinesByPriceRange(double minPrice, double maxPrice) {
        String sql = "SELECT * FROM medicines WHERE price BETWEEN ? AND ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, minPrice);
            pstmt.setDouble(2, maxPrice);

            ResultSet rs = pstmt.executeQuery();
            System.out.println("--- Danh sách thuốc trong khoảng giá ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Tên: %s | Giá: %.2f | Tồn: %d\n",
                        rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("stock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void calculatePrescriptionTotal(int prescriptionId) {
        String sql = "{CALL CalculatePrescriptionTotal(?, ?)}";
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, prescriptionId);
            cstmt.registerOutParameter(2, Types.DECIMAL);

            cstmt.execute();
            double total = cstmt.getDouble(2);
            System.out.println("Tổng tiền đơn thuốc ID " + prescriptionId + " là: " + total);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDailyRevenue(String dateStr) {
        String sql = "{CALL GetDailyRevenue(?, ?)}";
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setDate(1, Date.valueOf(dateStr)); // Định dạng yyyy-MM-dd
            cstmt.registerOutParameter(2, Types.DECIMAL);

            cstmt.execute();
            double revenue = cstmt.getDouble(2);
            System.out.println("Doanh thu ngày " + dateStr + " là: " + revenue);

        } catch (SQLException e) {
            System.out.println("Lỗi định dạng ngày hoặc SQL: " + e.getMessage());
        }
    }
}
