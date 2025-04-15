package com.example.ioc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemoRestViewController {

    @GetMapping("/memoForm")
    public String memoForm() {
        return "memo-rest";  // /WEB-INF/views/memo-rest.jsp
    }
}
