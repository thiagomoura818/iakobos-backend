package com.iakobos.iakobos.mapper;

import com.iakobos.iakobos.model.Translation;
import com.iakobos.iakobos.model.dto.Translation.TranslationResponse;

public class TranslationMapper {

    public static TranslationResponse toResponse(Translation translation){
        if(translation == null)
            return null;

        return new TranslationResponse(translation.getId(), translation.getName(), translation.getLanguage(), translation.getAbbreviation());
    }
}
