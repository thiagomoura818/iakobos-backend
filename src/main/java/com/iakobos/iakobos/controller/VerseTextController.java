package com.iakobos.iakobos.controller;

<<<<<<< HEAD
import com.iakobos.iakobos.dto.PageResponseDTO;
import com.iakobos.iakobos.dto.VerseTextDTO;
import com.iakobos.iakobos.service.VerseTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
=======
import com.iakobos.iakobos.model.dto.VerseText.VerseTextResponse;
import com.iakobos.iakobos.service.VerseTextService;
import lombok.RequiredArgsConstructor;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/versetext")
public class VerseTextController {

    private final VerseTextService verseTextService;

<<<<<<< HEAD
    @GetMapping("/chapters/translation/{translation}/book/{bookId}")
    public ResponseEntity<List<Integer>> findChaptersByBookAndTranslation(@PathVariable String translation, @PathVariable Short bookId){
        return ResponseEntity.ok(verseTextService.findChaptersByBookAndTranslation(translation, bookId));
    }

    @GetMapping("/verses/translation/{translation}/book/{bookId}/chapter/{chapter}")
    public ResponseEntity<List<VerseTextDTO>> findVerseByTBC(
            @PathVariable String translation,
            @PathVariable Short bookId,
            @PathVariable Integer chapter) {

        List<VerseTextDTO> verses = verseTextService.findVerseByTBC(translation, bookId, chapter);
=======
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
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
        return ResponseEntity.ok(verses);
    }

    @GetMapping("/verses/search")
<<<<<<< HEAD
    public ResponseEntity<PageResponseDTO<VerseTextDTO>> searchVerses(
            @RequestParam Short translationId,
            @RequestParam String term,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size){

        Pageable pageable = PageRequest.of(page, size);
        Page<VerseTextDTO> results = verseTextService.findBySearchTerm(translationId, term, pageable);

        return ResponseEntity.ok(PageResponseDTO.from(results));
=======
    public ResponseEntity<List<VerseTextResponse>> searchVerses(@RequestParam Short translationId, @RequestParam String term){
        List<VerseTextResponse> results = verseTextService.findBySearchTerm(translationId, term);
        return ResponseEntity.ok(results);
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
    }
}
