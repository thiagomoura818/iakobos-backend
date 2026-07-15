package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Short> {
    List<Book> findByTestamentId(Short id);

    // Selecionar todos os livros com base em uma tradução
    @Query("""
    SELECT DISTINCT b
    FROM Book b
    JOIN FETCH b.testament
    JOIN Verse v ON v.book = b
    JOIN VerseText vt ON vt.verseRef = v
    WHERE vt.translation.id = :translationId
    ORDER BY b.position
    """)
    List<Book> findBooksByTranslation(Short translationId);

    // Selecionar os livros de um testamento especifico e com base na traducao

    Optional<Book> findBookByAbbreviation(String abbreviation);

}
