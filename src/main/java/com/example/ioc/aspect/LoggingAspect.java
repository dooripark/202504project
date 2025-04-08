package com.example.ioc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.ioc.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("🟢 [Before] 실행 전 - " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.ioc.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("🔵 [After] 실행 후 - " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.ioc.service.*.*(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("✅ [AfterReturning] 정상 종료 - " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.ioc.service.*.*(..))")
    public void logAfterThrowing(JoinPoint joinPoint) {
        System.out.println("❌ [AfterThrowing] 예외 발생 - " + joinPoint.getSignature().getName());
    }

    @Around("execution(* com.example.ioc.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("⏱️ [Around] 실행 전 - " + joinPoint.getSignature().getName());

        try {
            Object result = joinPoint.proceed(); // 실제 서비스 메서드 실행
            return result;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("⏱️ [Around] 실행 후 - 소요 시간: " + (end - start) + "ms");
        }
    }
}
