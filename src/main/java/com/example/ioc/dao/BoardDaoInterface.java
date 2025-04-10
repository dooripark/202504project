package com.example.ioc.dao;

import com.example.ioc.vo.Board;
import java.util.List;

public interface BoardDaoInterface {
    List<Board> findAll();
    Board findById(int id);
    int insert(Board board);
    int update(Board board);
    int delete(int id);
}
