package com.iakobos.iakobos.controller;

import com.iakobos.iakobos.model.dto.VerseText.VerseTextResponse;
import com.iakobos.iakobos.service.VerseTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/versetext")
public class VerseTextController {

    private final VerseTextService verseTextService;

    @GetMapping("/chapters/translation/{translationId}/book/{bookId}")
    public ResponseEntity<List<Integer>> findChaptersByBookAndTranslation(@PathVariable Short translationId, @PathVariable Short bookId){
        return ResponseEntity.ok(verseTextService.findChaptersByBookAndTranslation(translationId, bookId));
    }

    @GetMapping("/verses/translation/{translationId}/book/{bookId}/chapter/{chapter}")
    public ResponseEntity<List<VerseTextResponse>> findVerseByTBC(
            @PathVariable Short translationId,
            @PathVariable Short bookId,
            @PathVariable Integer chapter) {

        List<VerseTextResponse> verses = verseTextService.findVerseByTBC(translationId, bookId, chapter);
        return ResponseEntity.ok(verses);
    }
}
