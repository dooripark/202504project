package com.example.ioc.repository;

import org.springframework.stereotype.Repository;

/**
 * 메모를 저장하는 저장소 클래스.
 */
@Repository
public class MemoRepository {
    public void save(String memo) {
        System.out.println("[메모 저장됨] " + memo);
    }
}
