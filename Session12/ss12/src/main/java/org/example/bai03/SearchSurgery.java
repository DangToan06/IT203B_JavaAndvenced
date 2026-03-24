package org.example.bai03;

import org.example.database.DBContext;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class SearchSurgery {
    public static void search(String surgery_id){
        String sql = "{call GET_SURGERY_FEE(?,?)}";
        try (Connection conn = DBContext.getConnection();
            CallableStatement cstmt = conn.prepareCall(sql);){

            cstmt.setString(1, surgery_id);
            cstmt.registerOutParameter(2, Types.DECIMAL);

            cstmt.execute();

            double fee = cstmt.getDouble(2);
            System.out.println("Chi phí phẫu thuật là: " + fee);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
