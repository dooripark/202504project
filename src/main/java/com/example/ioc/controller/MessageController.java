package com.example.ioc.controller;

import com.example.ioc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * 다형성 기반의 인터페이스 주입 예제.
 * @Qualifier를 사용해 어떤 구현체를 주입할지 지정한다.
 */
@Controller
public class MessageController {

    // 다형성 인터페이스 주입 시 어떤 구현체를 넣을지 지정해줘야 함
    @Autowired
    @Qualifier("email")  // "sms"로 바꾸면 SMSService가 주입됨
    private MessageService messageService;

    public void run() {
        messageService.send("다형성 + Qualifier 연습 완료!");
    }
}
