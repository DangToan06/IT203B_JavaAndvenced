package org.example.dao;

import org.example.database.DBContext;
import org.example.module.Doctors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public static void  findDoctorBySpecialty(String specialty){
        String sql = "select * from doctors where specialty = ?";
        List<Doctors> doctors =  new ArrayList<>();
        try (Connection conn = DBContext.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){

            pstmt.setString(1, specialty);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Doctors doctor = new Doctors();
                doctor.setId(rs.getInt("doctor_id"));
                doctor.setFullName(rs.getString("full_name"));
                doctor.setSpecialty(rs.getString("specialty"));
                doctor.setExpYears(rs.getInt("experience_years"));
                doctor.setBaseSalary(rs.getDouble("base_salary"));
                doctor.setPassword(rs.getString("password"));
                doctors.add(doctor);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
