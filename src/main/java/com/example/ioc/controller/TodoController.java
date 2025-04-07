package com.example.ioc.controller;

import com.example.ioc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 필드 주입 방식의 Controller.
 * TodoService를 @Autowired로 주입받아 사용.
 */
@Controller  // 스프링이 이 클래스를 컨트롤러로 인식하게 함
public class TodoController {

    @Autowired  // 스프링이 자동으로 TodoService를 주입
    private TodoService todoService;

    public void run() {
        todoService.addTask("Spring 공부하기");
        todoService.addTask("DI 개념 복습하기");
    }
}
