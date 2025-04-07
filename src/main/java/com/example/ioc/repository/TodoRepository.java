package com.example.ioc.repository;

import org.springframework.stereotype.Repository;

/**
 * 할 일(Task)을 저장하는 저장소 역할 클래스.
 * 현재는 메모리 출력으로만 처리됨.
 */
@Repository
public class TodoRepository {
    public void save(String task) {
        System.out.println("[저장됨] 할 일: " + task);
    }
}
