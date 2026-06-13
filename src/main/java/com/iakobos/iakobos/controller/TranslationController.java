package com.iakobos.iakobos.controller;

import com.iakobos.iakobos.model.dto.Translation.TranslationResponse;
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
    public ResponseEntity<List<TranslationResponse>> findAll(){
        List<TranslationResponse> responses = translationService.findAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TranslationResponse> findById(@PathVariable Short id){
        return ResponseEntity.ok(translationService.findById(id));
    }
}
