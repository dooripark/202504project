package com.example.ioc.controller;

import com.example.ioc.service.RestBoardService;
import com.example.ioc.vo.RestBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restboard")
public class RestBoardController {

    @Autowired
    private RestBoardService restBoardService;

    @GetMapping
    public List<RestBoard> listBoards() {
        return restBoardService.getAllBoards();
    }

    @PostMapping
    public ResponseEntity<String> createBoard(@RequestBody RestBoard board) {
        restBoardService.addBoard(board);
        return ResponseEntity
                .ok()
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body("게시글 등록 완료!");
    }
}
