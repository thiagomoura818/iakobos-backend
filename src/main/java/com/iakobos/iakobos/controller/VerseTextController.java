package com.iakobos.iakobos.controller;

import com.iakobos.iakobos.model.dto.VerseText.VerseTextResponse;
import com.iakobos.iakobos.service.VerseTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/versetext")
public class VerseTextController {

    private final VerseTextService verseTextService;

    @GetMapping("/chapters/translation/{translation}/book/{bookId}")
    public ResponseEntity<List<Integer>> findChaptersByBookAndTranslation(@PathVariable String translation, @PathVariable Short bookId){
        return ResponseEntity.ok(verseTextService.findChaptersByBookAndTranslation(translation, bookId));
    }

    @GetMapping("/verses/translation/{translation}/book/{bookId}/chapter/{chapter}")
    public ResponseEntity<List<VerseTextResponse>> findVerseByTBC(
            @PathVariable String translation,
            @PathVariable Short bookId,
            @PathVariable Integer chapter) {

        List<VerseTextResponse> verses = verseTextService.findVerseByTBC(translation, bookId, chapter);
        return ResponseEntity.ok(verses);
    }

    @GetMapping("/verses/search")
    public ResponseEntity<List<VerseTextResponse>> searchVerses(@RequestParam Short translationId, @RequestParam String term){
        List<VerseTextResponse> results = verseTextService.findBySearchTerm(translationId, term);
        return ResponseEntity.ok(results);
    }
}
