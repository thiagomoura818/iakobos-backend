package com.iakobos.iakobos.service;

import com.iakobos.iakobos.mapper.TranslationMapper;
import com.iakobos.iakobos.model.dto.Translation.TranslationResponse;
import com.iakobos.iakobos.repository.TranslationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TranslationService {

    private final TranslationRepository translationRepository;

    public List<TranslationResponse> findAll(){
        return translationRepository.findAll().stream().map(TranslationMapper::toResponse).toList();
    }

    public TranslationResponse findById(Short id){
        return TranslationMapper.toResponse(
                translationRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tradução não encontrada"))
        );
    }
}
