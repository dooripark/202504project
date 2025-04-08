package com.example.ioc.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public void sayHello() {
        System.out.println("👋 Hello, 두리오빠~ 😄");
    }

    public void throwError() {
        System.out.println("💥 일부러 예외 발생시킴!");
        throw new RuntimeException("예외 테스트용!");
    }
}