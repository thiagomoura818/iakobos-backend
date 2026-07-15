package com.iakobos.iakobos.service;

import com.iakobos.iakobos.exceptions.TestamentNotFoundException;
import com.iakobos.iakobos.mapper.TestamentMapper;
import com.iakobos.iakobos.dto.TestamentDTO;
import com.iakobos.iakobos.repository.TestamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestamentService {

    private final TestamentRepository testamentRepository;
    private final TestamentMapper testamentMapper;

    public List<TestamentDTO> findAll(){
        return testamentRepository.findAll().stream().map(testamentMapper::toResponse).toList();
    }

    public TestamentDTO findById(Short id){
        return testamentMapper.toResponse(testamentRepository.findById(id)
                .orElseThrow(() -> new TestamentNotFoundException(id)));
    }
}
