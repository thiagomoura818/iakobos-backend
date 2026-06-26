package com.iakobos.iakobos.repository;

import com.iakobos.iakobos.model.VerseNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VerseNoteRepository extends JpaRepository<VerseNote, Long> {

    @Query("""
    SELECT vn
    FROM VerseNote vn
    WHERE vn.user.id = :userId
    AND vn.verse.book.id = :bookId
    AND vn.verse.chapter = :chapter
    AND vn.verse.verse = :verse
    """)
    Optional<VerseNote> findNote(Long userId, Short bookId, Integer chapter, String verse);

}
