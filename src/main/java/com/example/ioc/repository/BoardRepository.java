package com.example.ioc.repository;

import com.example.ioc.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // 기본적인 CRUD는 여기서 자동 제공됨
}
