package com.iakobos.iakobos.service;

import com.iakobos.iakobos.mapper.VerseTextMapper;
import com.iakobos.iakobos.model.Translation;
import com.iakobos.iakobos.model.dto.VerseText.VerseTextResponse;
import com.iakobos.iakobos.repository.TranslationRepository;
import com.iakobos.iakobos.repository.VerseTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VerseTextService {

    private final VerseTextRepository verseTextRepository;
    private final TranslationService translationService;

    public List<Integer> findChaptersByBookAndTranslation(String abbreviation, Short bookId){
        Translation translation = translationService.findByAbbreviation(abbreviation);
        return verseTextRepository.findChaptersByBookAndTranslation(translation.getId(), bookId);
    }

    public List<VerseTextResponse> findVerseByTBC(String abbreviation, Short bookId, Integer chapter){
        Translation translation = translationService.findByAbbreviation(abbreviation);

        return verseTextRepository.findVerseTextByTBC(translation.getId(), bookId, chapter)
                .stream().map(VerseTextMapper::toResponse).toList();
    }

    public List<VerseTextResponse> findBySearchTerm(Short translationId, String searchTerm){
        System.out.println("LOG REAL " + searchTerm);
        String term = searchTerm.trim().replaceAll("\\s", "& ");
        System.out.println("FORMATADO: " + term);

        return verseTextRepository.searchVersesByText(translationId, term)
                .stream().map(VerseTextMapper::toResponse).toList();
    }
}
