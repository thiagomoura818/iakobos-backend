package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import java.util.Optional;

public interface TranslationRepository extends JpaRepository<Translation, Short> {
    Optional<Translation> findTranslationByAbbreviation(String abb);
=======
public interface TranslationRepository extends JpaRepository<Translation, Short> {
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
