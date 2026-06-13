package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<Translation, Short> {
}
