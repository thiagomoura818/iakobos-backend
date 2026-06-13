package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Short> {
    List<Book> findByTestamentId(Short id);

    // Selecionar todos os livros com base em uma tradução
    @Query("""
    SELECT DISTINCT b 
    FROM Book b 
    LEFT JOIN FETCH b.testament
    LEFT JOIN VerseText v ON v.book = b AND v.translation.id = :translationId
    ORDER BY b.position ASC
    """)
    List<Book> findBooksByTranslation(Short translationId);

    // Selecionar os livros de um testamento especifico e com base na traducao


}
