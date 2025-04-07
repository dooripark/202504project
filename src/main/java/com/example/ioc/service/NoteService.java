package com.example.ioc.service;

import com.example.ioc.repository.NoteRepository;
import org.springframework.stereotype.Service;

/**
 * 생성자 주입 방식 사용 예제.
 * final 키워드를 사용하여 불변성 유지 가능.
 */
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    // 생성자를 통한 의존성 주입
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void writeNote(String note) {
        noteRepository.save(note);
    }
}
