package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
=======

import java.util.List;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7

public interface BookRepository extends JpaRepository<Book, Short> {
    List<Book> findByTestamentId(Short id);

    // Selecionar todos os livros com base em uma tradução
    @Query("""
<<<<<<< HEAD
    SELECT DISTINCT b
    FROM Book b
    JOIN FETCH b.testament
    JOIN Verse v ON v.book = b
    JOIN VerseText vt ON vt.verseRef = v
    WHERE vt.translation.id = :translationId
    ORDER BY b.position
=======
    SELECT DISTINCT b 
    FROM Book b 
    LEFT JOIN FETCH b.testament
    LEFT JOIN VerseText v ON v.book = b AND v.translation.id = :translationId
    ORDER BY b.position ASC
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
    """)
    List<Book> findBooksByTranslation(Short translationId);

    // Selecionar os livros de um testamento especifico e com base na traducao

<<<<<<< HEAD
    Optional<Book> findBookByAbbreviation(String abbreviation);
=======
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7

}
