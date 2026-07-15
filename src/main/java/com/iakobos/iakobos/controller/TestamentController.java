package com.iakobos.iakobos.controller;

<<<<<<< HEAD
import com.iakobos.iakobos.dto.TestamentDTO;
=======
import com.iakobos.iakobos.model.dto.Testament.TestamentResponse;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
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
<<<<<<< HEAD
    public ResponseEntity<List<TestamentDTO>> findAll(){
        List<TestamentDTO> responses = testamentService.findAll();
=======
    public ResponseEntity<List<TestamentResponse>> findAll(){
        List<TestamentResponse> responses = testamentService.findAll();
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<TestamentDTO> findById(@PathVariable Short id){
=======
    public ResponseEntity<TestamentResponse> findById(@PathVariable Short id){
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
        return ResponseEntity.ok(testamentService.findById(id));
    }
}
