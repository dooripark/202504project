package com.example.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.annotation.PreDestroy;

@Configuration
@ComponentScan(basePackages = "com.example.ioc")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.ioc.repository")
public class AppConfig {

    @PreDestroy
    public void cleanup() {
        try {
            AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Exception e) {
            System.out.println("AbandonedConnectionCleanupThread shutdown failed: " + e.getMessage());
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("JDBC Driver shutdown failed: " + e.getMessage());
        }
    }
}
