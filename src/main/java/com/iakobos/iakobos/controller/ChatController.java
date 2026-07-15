package com.iakobos.iakobos.controller;

import com.iakobos.iakobos.ai.VerseNoteAIService;
import com.iakobos.iakobos.dto.VerseContextDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai")
public class ChatController {

    private final VerseNoteAIService service;

    @PostMapping("/evaluate/{verseNoteId}")
    public ResponseEntity<String> evaluate(@PathVariable Long verseNoteId,
                                           @RequestParam(required = false) Short translationId) {

        String evaluation = service.evaluate(verseNoteId, translationId);

        return ResponseEntity.ok(evaluation);
    }

}
