package com.iakobos.iakobos.service;

import com.iakobos.iakobos.dto.BookDTO;
import com.iakobos.iakobos.mapper.BookMapper;
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
    private final BookMapper bookMapper;

    public List<BookDTO> findAll(){
        return bookRepository.findAll().stream().map(bookMapper::toResponse).toList();
    }

    public BookDTO findById(Short id){
        return bookMapper.toResponse(bookRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)));
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
        return bookMapper.toResponse(bookRepository.findBookByAbbreviation(abbreviation).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)));

    }


}
