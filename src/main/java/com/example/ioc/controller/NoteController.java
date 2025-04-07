package com.example.ioc.controller;

import com.example.ioc.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 생성자 주입 방식의 Controller를 테스트하는 클래스.
 */
@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    public void run() {
        noteService.writeNote("의존성 주입 연습 - 생성자 방식");
    }
}
