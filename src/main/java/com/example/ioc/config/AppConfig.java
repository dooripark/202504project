package com.example.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 스프링 설정 클래스.
 * ComponentScan을 통해 해당 패키지 이하에 있는
 * @Component, @Service, @Controller, @Repository 어노테이션을 스캔하여 Bean으로 등록한다.
 */
@Configuration  // 스프링 설정 클래스임을 나타냄
@ComponentScan(basePackages = "com.example.ioc")  // 지정된 패키지 이하를 모두 스캔해서 Bean 등록
@EnableAspectJAutoProxy
public class AppConfig {
}
