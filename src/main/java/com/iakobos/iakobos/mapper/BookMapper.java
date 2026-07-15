package com.iakobos.iakobos.mapper;

<<<<<<< HEAD
import com.iakobos.iakobos.dto.BookDTO;
import com.iakobos.iakobos.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toResponse(Book book);
=======
import com.iakobos.iakobos.model.Book;
import com.iakobos.iakobos.model.dto.Book.BookResponse;

public class BookMapper {

    public static BookResponse toResponse(Book book){
        if(book == null)
            return null;

        return new BookResponse(book.getId(), book.getTestament().getId(), book.getName(), book.getAbbreviation(), book.getPosition());
    }
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
