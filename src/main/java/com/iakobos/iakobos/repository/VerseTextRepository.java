package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.VerseText;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7

public interface VerseTextRepository extends JpaRepository<VerseText, Long> {

    // Selecionar os capitulos com base no livro e na traducao
<<<<<<< HEAD
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
    """,
    countQuery = """
    SELECT count(vt.id)
    FROM verse_text vt 
    WHERE vt.translation_id = :translationId
        AND fts_unaccent(vt.text) @@ plainto_tsquery('portuguese',unaccent(:searchTerm))
    """, nativeQuery = true)
    Page<VerseText>
    searchVersesByText(
            @Param("translationId") Short translationId,
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

    @Query("SELECT vt FROM VerseText vt WHERE vt.translation.id = :translationId AND vt.verseRef.id = :verseId")
    Optional<VerseText> findByTranslationIdAndVerseId(@Param("translationId") Short translationId, @Param("verseId") Long verseId);

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
=======
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
    List<VerseText> findVerseTextByTBC(Short translationId, Short bookId, Integer chapter);

    @Query(value= """
    SELECT id, translation_id, book_id, chapter, verse AS verse_number, text
    FROM verse_text
    WHERE translation_id = :translationId
        AND fts_unaccent(text) @@ plainto_tsquery('portuguese', unaccent(:searchTerm))
    ORDER BY chapter ASC, CAST(verse as integer) ASC
    """, nativeQuery = true)
    List<VerseText> searchVersesByText(Short translationId, String searchTerm);
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
