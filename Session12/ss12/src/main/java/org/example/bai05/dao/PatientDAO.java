package org.example.bai05.dao;

import org.example.bai05.model.Patient;
import org.example.database.DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PatientDAO {

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM Patients";
        try (Connection conn = DBContext.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Patient(
                        rs.getString("patient_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getDate("admission_date")
                ));
            }
        }
        return list;
    }

    public void addPatient(Patient p) throws SQLException {
        String sql = "INSERT INTO Patients (patient_id, name, age, department, admission_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getId());
            pstmt.setString(2, p.getName());
            pstmt.setInt(3, p.getAge());
            pstmt.setString(4, p.getDepartment());
            pstmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            pstmt.executeUpdate();
        }
    }

    public void updateDepartment(String id, String newDept) throws SQLException {
        String sql = "UPDATE Patients SET department = ? WHERE patient_id = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newDept);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
        }
    }

    public double calculateFee(String patientId) throws SQLException {
        String sql = "{CALL CALCULATE_DISCHARGE_FEE(?, ?)}";
        try (Connection conn = DBContext.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, patientId);
            cstmt.registerOutParameter(2, Types.DECIMAL);
            cstmt.execute();
            return cstmt.getDouble(2);
        }
    }
}