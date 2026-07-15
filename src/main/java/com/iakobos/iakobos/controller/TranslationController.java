package com.iakobos.iakobos.controller;

<<<<<<< HEAD
import com.iakobos.iakobos.dto.TranslationDTO;
=======
import com.iakobos.iakobos.model.dto.Translation.TranslationResponse;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
import com.iakobos.iakobos.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/translation")
@RequiredArgsConstructor
@RestController
public class TranslationController {

    private final TranslationService translationService;

    @GetMapping("")
<<<<<<< HEAD
    public ResponseEntity<List<TranslationDTO>> findAll(){
        List<TranslationDTO> responses = translationService.findAll();
=======
    public ResponseEntity<List<TranslationResponse>> findAll(){
        List<TranslationResponse> responses = translationService.findAll();
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<TranslationDTO> findById(@PathVariable Short id){
=======
    public ResponseEntity<TranslationResponse> findById(@PathVariable Short id){
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
        return ResponseEntity.ok(translationService.findById(id));
    }
}
