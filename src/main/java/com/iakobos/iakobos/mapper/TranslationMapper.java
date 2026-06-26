package com.iakobos.iakobos.mapper;

import com.iakobos.iakobos.dto.TranslationDTO;
import com.iakobos.iakobos.model.Translation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TranslationMapper {

    TranslationDTO toResponse(Translation translation);
}
