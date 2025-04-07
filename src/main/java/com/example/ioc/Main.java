package com.example.ioc;

import com.example.ioc.config.AppConfig;
import com.example.ioc.controller.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring IoC 컨테이너를 사용하는 진입점 클래스.
 * AppConfig 설정을 기반으로 Bean을 등록하고,
 * 각각의 컨트롤러를 꺼내서 실행한다.
 */
public class Main {
    public static void main(String[] args) {
        // Annotation 기반 설정을 사용한 ApplicationContext 생성
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        // 각각의 컨트롤러를 실행 → 각 컨트롤러는 내부적으로 Service → Repository 호출
        ctx.getBean(TodoController.class).run();     // 필드 주입 예제
        ctx.getBean(NoteController.class).run();     // 생성자 주입 예제
        ctx.getBean(MemoController.class).run();     // 세터 주입 예제
        ctx.getBean(MessageController.class).run();  // 다형성 + Qualifier 예제
    }
}
