package com.iakobos.iakobos.mapper;

import com.iakobos.iakobos.dto.VerseTextDTO;
import com.iakobos.iakobos.model.VerseText;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VerseTextMapper {

    @Mapping(target="translationId", source = "translation.id")
    @Mapping(target="bookId", source="verseRef.book.id")
    @Mapping(target="chapter", source="verseRef.chapter")
    @Mapping(target="verse", source="verseRef.verse")
    VerseTextDTO toResponse(VerseText verseText);
}
