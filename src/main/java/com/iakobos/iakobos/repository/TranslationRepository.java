package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TranslationRepository extends JpaRepository<Translation, Short> {
    Optional<Translation> findTranslationByAbbreviation(String abb);
}
