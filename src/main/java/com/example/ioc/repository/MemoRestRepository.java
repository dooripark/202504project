package com.example.ioc.repository;

import com.example.ioc.dto.MemoRest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoRestRepository {

    private final List<MemoRest> memoList = new ArrayList<>();

    public List<MemoRest> findAll() {
        return memoList;
    }

    public void save(MemoRest memo) {
        memoList.add(memo);
    }
}
