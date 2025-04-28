package com.example.ioc.repository;

import com.example.ioc.entity.RestBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestBoardRepository extends JpaRepository<RestBoard, Long> {
    // findAll(), save() 기본 제공됨
}
