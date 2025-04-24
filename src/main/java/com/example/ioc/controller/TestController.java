package com.example.ioc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class TestController {

    @GetMapping("/utf8-test")
    public void utf8Test(HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("한글이 잘 보이나요?");
    }
}
