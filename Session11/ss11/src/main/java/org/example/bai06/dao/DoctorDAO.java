package org.example.bai06.dao;

import org.example.bai06.database.DBContext;
import org.example.bai06.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private DBContext db = new DBContext();

    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM Doctors";
        try (Connection conn = db.getHospitalConn();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                list.add(new Doctor(rs.getString("doctor_id"), rs.getString("full_name"), rs.getString("specialty")));
            }
        }
        return list;
    }

    public boolean addDoctor(Doctor d) throws SQLException {
        String sql = "INSERT INTO Doctors (doctor_id, full_name, specialty) VALUES (?, ?, ?)";
        try (Connection conn = db.getHospitalConn();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, d.getId());
            pstm.setString(2, d.getName());
            pstm.setString(3, d.getSpecialty());
            return pstm.executeUpdate() > 0;
        }
    }

    public void showStatistics() throws SQLException {
        String sql = "SELECT specialty, COUNT(*) as total FROM Doctors GROUP BY specialty";
        try (Connection conn = db.getHospitalConn();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            System.out.printf("%-20s | %-10s\n", "Chuyên khoa", "Số lượng BS");
            while (rs.next()) {
                System.out.printf("%-20s | %-10d\n", rs.getString("specialty"), rs.getInt("total"));
            }
        }
    }
}
