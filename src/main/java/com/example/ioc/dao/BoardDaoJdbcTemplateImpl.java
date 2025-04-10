package com.example.ioc.dao;

import com.example.ioc.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("boardDaoJdbcTemplateImpl")
public class BoardDaoJdbcTemplateImpl implements BoardDaoInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BoardDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Board> findAll() {
        String sql = "SELECT * FROM board ORDER BY id DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Board.class));
    }

    @Override
    public Board findById(int id) {
        String sql = "SELECT * FROM board WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Board.class), id);
    }

    @Override
    public int insert(Board board) {
        String sql = "INSERT INTO board (title, content, writer) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getWriter());
    }

    @Override
    public int update(Board board) {
        String sql = "UPDATE board SET title = ?, content = ? WHERE id = ?";
        return jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM board WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
