package com.example.ioc;

import com.example.ioc.config.AppConfig;
import com.example.ioc.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService helloService = context.getBean(HelloService.class);

        System.out.println("✅ sayHello 실행:");
        helloService.sayHello();

        System.out.println("\n❌ throwError 실행:");
        try {
            helloService.throwError();
        } catch (Exception e) {
            System.out.println("💬 MainApp에서 예외 잡음: " + e.getMessage());
        }

        context.close();
    }
}
