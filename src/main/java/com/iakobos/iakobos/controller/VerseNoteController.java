package com.iakobos.iakobos.controller;

import com.iakobos.iakobos.dto.CreateVerseNoteDTO;
import com.iakobos.iakobos.dto.UpdateVerseNoteDTO;
import com.iakobos.iakobos.dto.VerseNoteDTO;
import com.iakobos.iakobos.service.VerseNoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/versenote")
public class VerseNoteController {

    private final VerseNoteService verseNoteService;

    @PostMapping("")
    public ResponseEntity<VerseNoteDTO> insert(@RequestBody @Valid CreateVerseNoteDTO dto) {
        VerseNoteDTO created = verseNoteService.insert(dto);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();

        return ResponseEntity.created(location).body(verseNoteService.insert(dto));
    }

    @PutMapping("")
    public ResponseEntity<VerseNoteDTO> update(@RequestBody @Valid UpdateVerseNoteDTO dto) {
        return ResponseEntity.ok(verseNoteService.update(dto));
    }

    @GetMapping("/book/{bookId}/chapter/{chapter}/verse/{verse}")
    public ResponseEntity<VerseNoteDTO> getNote(
            @PathVariable Short bookId,
            @PathVariable Integer chapter,
            @PathVariable String verse) {
        return ResponseEntity.ok(verseNoteService.getNoteBySpecificVerse(bookId, chapter, verse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        verseNoteService.delete(id);

        return ResponseEntity.noContent().build();
    }



}
