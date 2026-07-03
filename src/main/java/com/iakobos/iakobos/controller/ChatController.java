package com.iakobos.iakobos.controller;

import com.iakobos.iakobos.ai.VerseNoteAIService;
import com.iakobos.iakobos.dto.VerseContextDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ChatController {

    private final VerseNoteAIService service;

    @PostMapping("/evaluate/{verseNoteId}")
    public ResponseEntity<String> evaluate(@PathVariable Long verseNoteId,
                                           @RequestParam(required = false) Short translationId) {

        String evaluation = service.evaluate(verseNoteId, translationId);

        return ResponseEntity.ok(evaluation);
    }

}
