package com.iakobos.iakobos.controller;

import com.iakobos.iakobos.model.dto.Testament.TestamentResponse;
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
    public ResponseEntity<List<TestamentResponse>> findAll(){
        List<TestamentResponse> responses = testamentService.findAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestamentResponse> findById(@PathVariable Short id){
        return ResponseEntity.ok(testamentService.findById(id));
    }
}
