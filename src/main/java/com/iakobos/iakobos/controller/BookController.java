package com.iakobos.iakobos.controller;

<<<<<<< HEAD
import com.iakobos.iakobos.dto.BookDTO;
import com.iakobos.iakobos.service.BookService;
=======
import com.iakobos.iakobos.model.dto.Book.BookResponse;
import com.iakobos.iakobos.service.BookService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
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
<<<<<<< HEAD
    public ResponseEntity<List<BookDTO>> findAll(){
        List<BookDTO> responses = bookService.findAll();
=======
    public ResponseEntity<List<BookResponse>> findAll(){
        List<BookResponse> responses = bookService.findAll();
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<BookDTO> findById(@PathVariable Short id){
=======
    public ResponseEntity<BookResponse> findById(@PathVariable Short id){
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping("/testament/{id}")
<<<<<<< HEAD
    public ResponseEntity<List<BookDTO>> findByTestament(@PathVariable Short id){
=======
    public ResponseEntity<List<BookResponse>> findByTestament(@PathVariable Short id){
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
        return ResponseEntity.ok(bookService.findByTestamentId(id));
    }

    @GetMapping("/translation/{id}")
<<<<<<< HEAD
    public ResponseEntity<List<BookDTO>> findByTranslation(@PathVariable Short id){
        return ResponseEntity.ok(bookService.findByTranslationId(id));
    }

    @GetMapping("/abbreviation/{abbreviation}")
    public ResponseEntity<BookDTO> findBookByAbbreviation(@PathVariable String abbreviation){
        return ResponseEntity.ok(bookService.findBookByAbbreviation(abbreviation));
    }
=======
    public ResponseEntity<List<BookResponse>> findByTranslation(@PathVariable Short id){
        return ResponseEntity.ok(bookService.findByTranslationId(id));
    }


>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
