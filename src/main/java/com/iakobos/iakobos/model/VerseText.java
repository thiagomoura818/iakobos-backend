package com.iakobos.iakobos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
<<<<<<< HEAD
        name = "verse_text",
        indexes = {
                @Index(name = "idx_reference", columnList = "translation_id,verse_id")
=======
        name = "verses",
        indexes = {
                @Index(name = "idx_reference", columnList = "book_id, chapter, verse_number")
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerseText {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "translation_id", nullable = false)
    private Translation translation;

<<<<<<< HEAD
    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verse_id")
    private Verse verseRef;
=======
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private Integer chapter;

    @Column(name = "verse_number", nullable = false, length = 15)
    private String verse;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
