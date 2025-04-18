package com.example.ioc.dao;

import com.example.ioc.vo.RestBoard;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestBoardDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<RestBoard> findAll() {
        return sqlSession.selectList("restBoard.findAll");
    }

    public void save(RestBoard board) {
        sqlSession.insert("restBoard.save", board);
    }
}
