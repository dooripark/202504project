package com.example.ioc.dao;

import com.example.ioc.vo.Board;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class BoardDao_ManualJdbc {

    private final DataSource dataSource;

    public BoardDao_ManualJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Board findById(int id) {
        Board board = null;
        String sql = "SELECT * FROM board WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                board = new Board();
                board.setId(rs.getInt("id"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setWriter(rs.getString("writer"));
                board.setCreatedAt(rs.getTimestamp("created_at"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return board;
    }
}
