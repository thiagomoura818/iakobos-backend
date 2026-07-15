package com.iakobos.iakobos.mapper;

<<<<<<< HEAD
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
=======
import com.iakobos.iakobos.model.VerseText;
import com.iakobos.iakobos.model.dto.VerseText.VerseTextResponse;

public class VerseTextMapper {

    public static VerseTextResponse toResponse(VerseText verseText){
        if(verseText == null)
            return null;

        return new VerseTextResponse(verseText.getId(), verseText.getTranslation().getId(),verseText.getBook().getId(),verseText.getChapter(), verseText.getVerse(), verseText.getText());
    }
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
