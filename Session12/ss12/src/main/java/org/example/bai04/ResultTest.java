package org.example.bai04;

import org.example.database.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ResultTest {

    public static void enterResult(List<Result> results){
        String sql = "INSERT INTO result VALUES (?, ?)";

        try(Connection conn = DBContext.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            conn.setAutoCommit(false);

            for (Result result : results){
                pstmt.setString(1, result.getResultID());
                pstmt.setString(2, result.getResultText());

                pstmt.addBatch();
            }

            pstmt.executeBatch();
            pstmt.clearBatch();
            conn.commit();
            System.out.println("Thêm tất cả bản ghi thành công");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
