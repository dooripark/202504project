package com.example.ioc.service;

import com.example.ioc.dto.MemoRest;
import com.example.ioc.repository.MemoRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoRestService {

    @Autowired
    private MemoRestRepository memoRestRepository;

    public List<MemoRest> getAllMemos() {
        return memoRestRepository.findAll();
    }

    public void addMemo(MemoRest memo) {
        memoRestRepository.save(memo);
    }
}
