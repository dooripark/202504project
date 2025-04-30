package com.example.ioc.service;

import com.example.ioc.dto.RestBoardDto;
import com.example.ioc.entity.RestBoard;
import com.example.ioc.mapper.RestBoardMapper;
import com.example.ioc.repository.RestBoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestBoardService {

    private final RestBoardRepository restBoardRepository;

    public RestBoardService(RestBoardRepository restBoardRepository) {
        this.restBoardRepository = restBoardRepository;
    }

    public List<RestBoardDto> getAllBoards() {
        return restBoardRepository.findAll().stream()
                .map(RestBoardMapper::toDto)
                .collect(Collectors.toList());
    }

    public void addBoard(RestBoardDto boardDto) {
        RestBoard entity = RestBoardMapper.toEntity(boardDto);
        restBoardRepository.save(entity);
    }
}
