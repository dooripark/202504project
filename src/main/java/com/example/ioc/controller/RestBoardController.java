package com.example.ioc.controller;

import com.example.ioc.dto.RestBoardDto;
import com.example.ioc.service.RestBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restboard")
public class RestBoardController {

    private final RestBoardService restBoardService;

    public RestBoardController(RestBoardService restBoardService) {
        this.restBoardService = restBoardService;
    }

    @GetMapping
    public ResponseEntity<List<RestBoardDto>> listBoards() {
        return ResponseEntity.ok(restBoardService.getAllBoards());
    }

    @PostMapping
    public ResponseEntity<String> createBoard(@RequestBody RestBoardDto boardDto) {
        restBoardService.addBoard(boardDto);
        return ResponseEntity
                .ok()
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body("게시글 등록 완료!");
    }
}
