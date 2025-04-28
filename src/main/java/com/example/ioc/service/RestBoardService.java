package com.example.ioc.service;

import com.example.ioc.entity.RestBoard;
import com.example.ioc.repository.RestBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestBoardService {

    @Autowired
    private RestBoardRepository restBoardRepository;

    // 전체 게시글 조회
    public List<RestBoard> getAllBoards() {
        return restBoardRepository.findAll();
    }

    // 게시글 추가
    public void addBoard(RestBoard board) {
        restBoardRepository.save(board);
    }
}
