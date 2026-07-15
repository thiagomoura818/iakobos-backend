package com.iakobos.iakobos.mapper;

<<<<<<< HEAD
import com.iakobos.iakobos.dto.TranslationDTO;
import com.iakobos.iakobos.model.Translation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TranslationMapper {

    TranslationDTO toResponse(Translation translation);
=======
import com.iakobos.iakobos.model.Translation;
import com.iakobos.iakobos.model.dto.Translation.TranslationResponse;

public class TranslationMapper {

    public static TranslationResponse toResponse(Translation translation){
        if(translation == null)
            return null;

        return new TranslationResponse(translation.getId(), translation.getName(), translation.getLanguage(), translation.getAbbreviation());
    }
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
