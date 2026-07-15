package com.iakobos.iakobos.service;

<<<<<<< HEAD
import com.iakobos.iakobos.dto.BookDTO;
import com.iakobos.iakobos.exceptions.BookNotFoundException;
import com.iakobos.iakobos.mapper.BookMapper;
import com.iakobos.iakobos.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
=======
import com.iakobos.iakobos.mapper.BookMapper;
import com.iakobos.iakobos.model.dto.Book.BookResponse;
import com.iakobos.iakobos.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
<<<<<<< HEAD
    private final BookMapper bookMapper;

    public List<BookDTO> findAll(){
        return bookRepository.findAll().stream().map(bookMapper::toResponse).toList();
    }

    public BookDTO findById(Short id){
        return bookMapper.toResponse(bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id)));
    }

    public List<BookDTO> findByTestamentId(Short id){
        return bookRepository.findByTestamentId(id).stream().map(bookMapper::toResponse).toList();
    }

    //Select the books by translation id
    public List<BookDTO> findByTranslationId(Short id){
        return bookRepository.findBooksByTranslation(id)
                .stream().map(bookMapper::toResponse).toList();
    }

    public BookDTO findBookByAbbreviation(String abbreviation){
        return bookMapper.toResponse(bookRepository.findBookByAbbreviation(abbreviation).orElseThrow(()-> new BookNotFoundException(abbreviation)));

    }


=======

    public List<BookResponse> findAll(){
        return bookRepository.findAll().stream().map(BookMapper::toResponse).toList();
    }

    public BookResponse findById(Short id){
        return BookMapper.toResponse(bookRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public List<BookResponse> findByTestamentId(Short id){
        return bookRepository.findByTestamentId(id).stream().map(BookMapper::toResponse).toList();
    }

    //Select the books by translation id
    public List<BookResponse> findByTranslationId(Short id){
        return bookRepository.findBooksByTranslation(id)
                .stream().map(BookMapper::toResponse).toList();
    }
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
