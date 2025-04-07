package com.example.ioc.service;

import com.example.ioc.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 기본적인 필드 주입 방식의 서비스 클래스.
 * TodoRepository를 이용해 할 일을 저장함.
 */
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public void addTask(String task) {
        todoRepository.save(task);
    }
}
