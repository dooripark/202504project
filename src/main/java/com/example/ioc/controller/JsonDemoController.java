package com.example.ioc.controller;

import com.example.ioc.vo.UserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/json-demo")
public class JsonDemoController {

    // JSON 응답 테스트용 - 단순한 GET 요청
    @GetMapping("/info")
    public ResponseEntity<UserInfo> getInfo() {
        UserInfo user = new UserInfo();
        user.setId(1);
        user.setName("홍길동");
        user.setEmail("hong@test.com");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // JSON 요청 수신 및 응답 테스트 - POST 요청
    @PostMapping("/save")
    public ResponseEntity<String> saveInfo(@RequestBody UserInfo userInfo) {
        System.out.println("받은 데이터: " + userInfo);

        // 한글 깨짐 방지: Content-Type 헤더에 UTF-8 명시
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body("성공적으로 저장되었습니다!");
    }
}
