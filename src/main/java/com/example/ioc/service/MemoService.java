package com.example.ioc.service;

import com.example.ioc.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 세터 주입 방식 사용 예제.
 * 선택적 의존성 주입이 필요한 경우나 테스트 상황에서 유용함.
 */
@Service
public class MemoService {

    private MemoRepository memoRepository;

    @Autowired  // 세터 주입 방식
    public void setMemoRepository(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public void writeMemo(String memo) {
        memoRepository.save(memo);
    }
}
