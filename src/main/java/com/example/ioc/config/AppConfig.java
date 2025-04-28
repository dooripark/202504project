package com.example.ioc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.ioc.repository")
public class AppConfig {
    // Spring Boot에서는 별도로 DataSource, EntityManagerFactory, TransactionManager를 설정할 필요 없음!
    // application.properties에 설정한 값으로 자동 구성됨.
}
