package com.iakobos.iakobos.service;

import com.iakobos.iakobos.mapper.BookMapper;
import com.iakobos.iakobos.model.dto.Book.BookResponse;
import com.iakobos.iakobos.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

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

    public BookResponse findBookByAbbreviation(String abbreviation){
        System.out.println(abbreviation);
        return BookMapper.toResponse(bookRepository.findBookByAbbreviation(abbreviation).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)));

    }
}
