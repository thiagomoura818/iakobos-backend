package com.iakobos.iakobos.service;

<<<<<<< HEAD
import com.iakobos.iakobos.dto.TranslationDTO;
import com.iakobos.iakobos.exceptions.TranslationNotFoundException;
import com.iakobos.iakobos.mapper.TranslationMapper;
import com.iakobos.iakobos.model.Translation;
import com.iakobos.iakobos.repository.TranslationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
=======
import com.iakobos.iakobos.mapper.TranslationMapper;
import com.iakobos.iakobos.model.dto.Translation.TranslationResponse;
import com.iakobos.iakobos.repository.TranslationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7

import java.util.List;

@RequiredArgsConstructor
@Service
public class TranslationService {

    private final TranslationRepository translationRepository;
<<<<<<< HEAD
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
=======

    public List<TranslationResponse> findAll(){
        return translationRepository.findAll().stream().map(TranslationMapper::toResponse).toList();
    }

    public TranslationResponse findById(Short id){
        return TranslationMapper.toResponse(
                translationRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tradução não encontrada"))
        );
    }
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
