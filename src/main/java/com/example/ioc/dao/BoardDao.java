// src/main/java/com/example/ioc/dao/BoardDao.java
package com.example.ioc.dao;

import com.example.ioc.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Board> findAll() {
        String sql = "SELECT * FROM board ORDER BY id DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Board.class));
    }

    public Board findById(int id) {
        String sql = "SELECT * FROM board WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Board.class), id);
    }

    public int insert(Board board) {
        String sql = "INSERT INTO board (title, content, writer) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getWriter());
    }

    public int update(Board board) {
        String sql = "UPDATE board SET title = ?, content = ? WHERE id = ?";
        return jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM board WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
