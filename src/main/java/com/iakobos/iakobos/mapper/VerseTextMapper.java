package com.iakobos.iakobos.mapper;

import com.iakobos.iakobos.model.VerseText;
import com.iakobos.iakobos.model.dto.VerseText.VerseTextResponse;

public class VerseTextMapper {

    public static VerseTextResponse toResponse(VerseText verseText){
        if(verseText == null)
            return null;

        return new VerseTextResponse(verseText.getId(), verseText.getTranslation().getId(),verseText.getBook().getId(),verseText.getChapter(), verseText.getVerse(), verseText.getText());
    }
}
