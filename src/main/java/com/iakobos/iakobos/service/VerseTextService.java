package com.iakobos.iakobos.service;

import com.iakobos.iakobos.mapper.VerseTextMapper;
import com.iakobos.iakobos.model.dto.VerseText.VerseTextResponse;
import com.iakobos.iakobos.repository.VerseTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VerseTextService {

    private final VerseTextRepository verseTextRepository;

    public List<Integer> findChaptersByBookAndTranslation(Short translationId, Short bookId){
        return verseTextRepository.findChaptersByBookAndTranslation(translationId, bookId);
    }

    public List<VerseTextResponse> findVerseByTBC(Short translationId, Short bookId, Integer chapter){
        return verseTextRepository.findVerseTextByTBC(translationId, bookId, chapter)
                .stream().map(VerseTextMapper::toResponse).toList();
    }
}
