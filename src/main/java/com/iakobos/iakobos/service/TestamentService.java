package com.iakobos.iakobos.service;

import com.iakobos.iakobos.mapper.TestamentMapper;
import com.iakobos.iakobos.model.Testament;
import com.iakobos.iakobos.model.dto.Testament.TestamentResponse;
import com.iakobos.iakobos.repository.TestamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestamentService {

    private final TestamentRepository testamentRepository;

    public List<TestamentResponse> findAll(){
        return testamentRepository.findAll().stream().map(TestamentMapper::toResponse).toList();
    }

    public TestamentResponse findById(Short id){
        return TestamentMapper.toResponse(testamentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Testamento não encontrado")));    }
}
