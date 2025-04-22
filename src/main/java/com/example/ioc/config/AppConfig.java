package com.example.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.annotation.PreDestroy;

@Configuration
@ComponentScan(basePackages = "com.example.ioc")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {

    // 웹 애플리케이션 종료 시 호출되는 메소드
    @PreDestroy
    public void cleanup() {
        // AbandonedConnectionCleanupThread 종료
        try {
            AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Exception e) {
            // 예외 발생 시, 에러 출력
            System.out.println("AbandonedConnectionCleanupThread shutdown failed: " + e.getMessage());
        }

        // MySQL 드라이버 강제 해제
        try {
            // JDBC 드라이버 강제 해제
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            // 예외가 발생하면 출력합니다
            System.out.println("JDBC Driver shutdown failed: " + e.getMessage());
        }
    }
}
