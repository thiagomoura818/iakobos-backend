package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.VerseText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VerseTextRepository extends JpaRepository<VerseText, Long> {

    // Selecionar os capitulos com base no livro e na traducao
    @Query("""
    SELECT DISTINCT vt.verseRef.chapter
    FROM VerseText vt
    WHERE vt.translation.id = :translationId
      AND vt.verseRef.book.id = :bookId
    ORDER BY vt.verseRef.chapter
    """)
    List<Integer> findChaptersByBookAndTranslation(
            @Param("translationId") Short translationId,
            @Param("bookId") Short bookId);

    // Selecionar os versiculos de um livro, capitulo e com base na traduacao
    @Query(value = """
    SELECT vt.*
    FROM verse_text vt
    JOIN verse v ON v.id = vt.verse_id
    WHERE vt.translation_id = :translationId
      AND v.book_id = :bookId
      AND v.chapter = :chapter
    ORDER BY CAST(v.verse AS integer)
    """, nativeQuery = true)
    List<VerseText> findVerseTextByTBC(
            Short translationId,
            Short bookId,
            Integer chapter);

    @Query(value= """
    SELECT vt.*
    FROM verse_text vt
    JOIN verse v ON v.id = vt.verse_id
    WHERE vt.translation_id = :translationId
    AND fts_unaccent(vt.text)
        @@ plainto_tsquery('portuguese', unaccent(:searchTerm))
    ORDER BY v.chapter,
             CAST(v.verse AS integer)
    """, nativeQuery = true)
    List<VerseText> searchVersesByText(Short translationId, String searchTerm);

    /*
    @Query(value = "SELECT v.* FROM verse v " +
            "JOIN chapter c ON v.chapter_id = c.id " +
            "JOIN book b ON c.book_id = b.id " +
            "WHERE unaccent(lower(b.name)) = unaccent(lower(:bookName)) " +
            "AND c.number = :chapter " +
            "AND v.number = :verse " +
            "AND v.translation_id = :translationId", nativeQuery = true)
    List<VerseText> findSpecificVerse(@Param("bookName") String bookName,
                                  @Param("chapter") Integer chapter,
                                  @Param("verse") String verse,
                                  @Param("translationId") Short translationId);*/
}
