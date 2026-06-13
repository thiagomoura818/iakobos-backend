package com.iakobos.iakobos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "verses",
        indexes = {
                @Index(name = "idx_reference", columnList = "book_id, chapter, verse_number")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private Integer chapter;

    @Column(name = "verse_number", nullable = false, length = 15)
    private String verse;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;
}
