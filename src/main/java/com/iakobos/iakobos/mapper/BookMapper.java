package com.iakobos.iakobos.mapper;

import com.iakobos.iakobos.model.Book;
import com.iakobos.iakobos.model.dto.Book.BookResponse;

public class BookMapper {

    public static BookResponse toResponse(Book book){
        if(book == null)
            return null;

        return new BookResponse(book.getId(), book.getTestament().getId(), book.getName(), book.getAbbreviation(), book.getPosition());
    }
}
