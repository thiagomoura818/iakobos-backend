package com.iakobos.iakobos.service;

import com.iakobos.iakobos.dto.TranslationDTO;
import com.iakobos.iakobos.exceptions.TranslationNotFoundException;
import com.iakobos.iakobos.mapper.TranslationMapper;
import com.iakobos.iakobos.model.Translation;
import com.iakobos.iakobos.repository.TranslationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TranslationService {

    private final TranslationRepository translationRepository;
    private final TranslationMapper translationMapper;

    public List<TranslationDTO> findAll(){
        return translationRepository.findAll().stream().map(translationMapper::toResponse).toList();
    }

    public TranslationDTO findById(Short id){
        return translationMapper.toResponse(
                translationRepository.findById(id).orElseThrow(()-> new TranslationNotFoundException(id))
        );
    }

    protected Translation findByAbbreviation(String abbreviation){
        return this.translationRepository.findTranslationByAbbreviation(abbreviation).orElseThrow(()-> new TranslationNotFoundException(abbreviation));
    }
}
