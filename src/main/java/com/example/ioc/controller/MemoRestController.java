package com.example.ioc.controller;

import com.example.ioc.dto.MemoRest;
import com.example.ioc.service.MemoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memos")
public class MemoRestController {

    @Autowired
    private MemoRestService memoRestService;

    @GetMapping
    public List<MemoRest> getAllMemos() {
        return memoRestService.getAllMemos();
    }

    @PostMapping
    public ResponseEntity<String> addMemo(@RequestBody MemoRest memo) {
        memoRestService.addMemo(memo);
        return ResponseEntity
                .ok()
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body("메모가 저장되었습니다!");
    }
}
