package com.iakobos.iakobos.service;

<<<<<<< HEAD
import com.iakobos.iakobos.exceptions.TestamentNotFoundException;
import com.iakobos.iakobos.mapper.TestamentMapper;
import com.iakobos.iakobos.dto.TestamentDTO;
import com.iakobos.iakobos.repository.TestamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
=======
import com.iakobos.iakobos.mapper.TestamentMapper;
import com.iakobos.iakobos.model.Testament;
import com.iakobos.iakobos.model.dto.Testament.TestamentResponse;
import com.iakobos.iakobos.repository.TestamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestamentService {

    private final TestamentRepository testamentRepository;
<<<<<<< HEAD
    private final TestamentMapper testamentMapper;

    public List<TestamentDTO> findAll(){
        return testamentRepository.findAll().stream().map(testamentMapper::toResponse).toList();
    }

    public TestamentDTO findById(Short id){
        return testamentMapper.toResponse(testamentRepository.findById(id)
                .orElseThrow(() -> new TestamentNotFoundException(id)));
    }
=======

    public List<TestamentResponse> findAll(){
        return testamentRepository.findAll().stream().map(TestamentMapper::toResponse).toList();
    }

    public TestamentResponse findById(Short id){
        return TestamentMapper.toResponse(testamentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Testamento não encontrado")));    }
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
