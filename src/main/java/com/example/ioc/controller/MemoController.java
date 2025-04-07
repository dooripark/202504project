package com.example.ioc.controller;

import com.example.ioc.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 세터 주입 방식의 Controller를 테스트하는 클래스.
 */
@Controller
public class MemoController {

    @Autowired
    private MemoService memoService;

    public void run() {
        memoService.writeMemo("세터 주입 방식 연습 중~");
    }
}
