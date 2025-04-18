package com.example.ioc.service;

import com.example.ioc.dao.RestBoardDao;
import com.example.ioc.vo.RestBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestBoardService {

    @Autowired
    private RestBoardDao restBoardDao;

    public List<RestBoard> getAllBoards() {
        return restBoardDao.findAll();
    }

    public void addBoard(RestBoard board) {
        restBoardDao.save(board);
    }
}
