package com.example.ioc.service;

/**
 * 다형성을 위한 공통 인터페이스.
 * 구현체로 EmailService, SmsService가 존재함.
 */
public interface MessageService {
    void send(String msg);
}
