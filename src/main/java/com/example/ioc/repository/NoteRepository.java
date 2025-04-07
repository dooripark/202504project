package com.example.ioc.repository;

import org.springframework.stereotype.Repository;

/**
 * 노트를 저장하는 저장소 클래스.
 */
@Repository
public class NoteRepository {
    public void save(String note) {
        System.out.println("[노트 저장됨] " + note);
    }
}
