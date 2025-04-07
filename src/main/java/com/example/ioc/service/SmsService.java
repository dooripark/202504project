package com.example.ioc.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * MessageService 구현체.
 * @Qualifier("sms")로 등록됨.
 */
@Service
@Qualifier("sms")
public class SmsService implements MessageService {
    public void send(String msg) {
        System.out.println("[SMS] " + msg);
    }
}
