package com.iakobos.iakobos.mapper;

import com.iakobos.iakobos.dto.VerseNoteDTO;
import com.iakobos.iakobos.model.VerseNote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VerseNoteMapper {
    @Mapping(target="verseId", source = "verse.id")
    VerseNoteDTO toResponse(VerseNote verseNote);
}
