package com.iakobos.iakobos.service;

import com.iakobos.iakobos.dto.VerseTextDTO;
import com.iakobos.iakobos.mapper.VerseTextMapper;
import com.iakobos.iakobos.model.Translation;
import com.iakobos.iakobos.repository.VerseTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VerseTextService {

    private final VerseTextRepository verseTextRepository;
    private final TranslationService translationService;
    private final VerseTextMapper verseTextMapper;

    public List<Integer> findChaptersByBookAndTranslation(String abbreviation, Short bookId){
        Translation translation = translationService.findByAbbreviation(abbreviation);
        return verseTextRepository.findChaptersByBookAndTranslation(translation.getId(), bookId);
    }

    public List<VerseTextDTO> findVerseByTBC(String abbreviation, Short bookId, Integer chapter){
        Translation translation = translationService.findByAbbreviation(abbreviation);

        return verseTextRepository.findVerseTextByTBC(translation.getId(), bookId, chapter)
                .stream().map(verseTextMapper::toResponse).toList();
    }

    public Page<VerseTextDTO> findBySearchTerm(
            Short translationId,
            String searchTerm,
            Pageable pageable){
        return verseTextRepository.searchVersesByText(translationId, searchTerm, pageable)
                .map(verseTextMapper::toResponse);
    }

}
