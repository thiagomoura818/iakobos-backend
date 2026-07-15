package com.iakobos.iakobos.service;

<<<<<<< HEAD
import com.iakobos.iakobos.dto.VerseTextDTO;
import com.iakobos.iakobos.mapper.VerseTextMapper;
import com.iakobos.iakobos.model.Translation;
import com.iakobos.iakobos.repository.VerseTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
=======
import com.iakobos.iakobos.mapper.VerseTextMapper;
import com.iakobos.iakobos.model.dto.VerseText.VerseTextResponse;
import com.iakobos.iakobos.repository.VerseTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7

import java.util.List;

@RequiredArgsConstructor
@Service
public class VerseTextService {

    private final VerseTextRepository verseTextRepository;
<<<<<<< HEAD
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

=======

    public List<Integer> findChaptersByBookAndTranslation(Short translationId, Short bookId){
        return verseTextRepository.findChaptersByBookAndTranslation(translationId, bookId);
    }

    public List<VerseTextResponse> findVerseByTBC(Short translationId, Short bookId, Integer chapter){
        return verseTextRepository.findVerseTextByTBC(translationId, bookId, chapter)
                .stream().map(VerseTextMapper::toResponse).toList();
    }

    public List<VerseTextResponse> findBySearchTerm(Short translationId, String searchTerm){
        System.out.println("LOG REAL " + searchTerm);
        String term = searchTerm.trim().replaceAll("\\s", "& ");
        System.out.println("FORMATADO: " + term);

        return verseTextRepository.searchVersesByText(translationId, term)
                .stream().map(VerseTextMapper::toResponse).toList();
    }
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
