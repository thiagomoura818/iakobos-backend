package com.iakobos.iakobos.controller;

import com.iakobos.iakobos.dto.TestamentDTO;
import com.iakobos.iakobos.service.TestamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/testament")
public class TestamentController {
    private final TestamentService testamentService;

    @GetMapping("")
    public ResponseEntity<List<TestamentDTO>> findAll(){
        List<TestamentDTO> responses = testamentService.findAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestamentDTO> findById(@PathVariable Short id){
        return ResponseEntity.ok(testamentService.findById(id));
    }
}
