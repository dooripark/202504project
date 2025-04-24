package com.example.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.JpaVendorAdapter;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

@Configuration
@ComponentScan(basePackages = "com.example.ioc")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.ioc.repository")
public class AppConfig {

    // ✅ DataSource 설정
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/boarddb?useSSL=false&serverTimezone=Asia/Seoul");
        dataSource.setUsername("root");
        dataSource.setPassword("tmvkdlejaos12@");
        return dataSource;
    }

    // ✅ JPA Vendor Adapter 설정
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    // ✅ EntityManagerFactory 설정 (BoardEntity 포함 경로 스캔)
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.example.ioc.domain", "com.example.ioc.entity"); // 🔥 여기 중요!
        emf.setJpaVendorAdapter(jpaVendorAdapter());
        return emf;
    }

    // ✅ 트랜잭션 매니저 설정
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    // ✅ MySQL 커넥션 클린업
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
