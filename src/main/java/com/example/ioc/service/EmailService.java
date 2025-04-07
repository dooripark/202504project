package com.example.ioc.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * MessageService 구현체.
 * @Qualifier("email")로 등록됨.
 */
@Service
@Qualifier("email")
public class EmailService implements MessageService {
    public void send(String msg) {
        System.out.println("[이메일] " + msg);
    }
}
