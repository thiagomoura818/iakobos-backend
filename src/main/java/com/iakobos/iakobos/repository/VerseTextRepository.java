package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.VerseText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VerseTextRepository extends JpaRepository<VerseText, Long> {

    // Selecionar os capitulos com base no livro e na traducao
    @Query(value="""
    SELECT DISTINCT v.chapter
    FROM verse_text v\s
    WHERE v.translation_id = :translationId
    AND v.book_id = :bookId
    ORDER BY v.chapter
    """, nativeQuery = true)
    List<Integer> findChaptersByBookAndTranslation(Short translationId, Short bookId);

    // Selecionar os versiculos de um livro, capitulo e com base na traduacao
    @Query(value = """
    SELECT id, translation_id, book_id, chapter, verse AS verse_number, text 
    FROM verse_text 
    WHERE translation_id = :translationId 
      AND book_id = :bookId
      AND chapter = :chapter
    ORDER BY CAST(verse AS integer) ASC
    """, nativeQuery = true)
    List<VerseText> findVerseTextByTBC(Short translationId, Short bookId, Integer chapter);}
