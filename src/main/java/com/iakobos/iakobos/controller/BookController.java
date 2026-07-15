package com.iakobos.iakobos.controller;

import com.iakobos.iakobos.dto.BookDTO;
import com.iakobos.iakobos.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<BookDTO>> findAll(){
        List<BookDTO> responses = bookService.findAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Short id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping("/testament/{id}")
    public ResponseEntity<List<BookDTO>> findByTestament(@PathVariable Short id){
        return ResponseEntity.ok(bookService.findByTestamentId(id));
    }

    @GetMapping("/translation/{id}")
    public ResponseEntity<List<BookDTO>> findByTranslation(@PathVariable Short id){
        return ResponseEntity.ok(bookService.findByTranslationId(id));
    }

    @GetMapping("/abbreviation/{abbreviation}")
    public ResponseEntity<BookDTO> findBookByAbbreviation(@PathVariable String abbreviation){
        return ResponseEntity.ok(bookService.findBookByAbbreviation(abbreviation));
    }
}
