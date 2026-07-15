package com.iakobos.iakobos.mapper;

import com.iakobos.iakobos.dto.BookDTO;
import com.iakobos.iakobos.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toResponse(Book book);
}
