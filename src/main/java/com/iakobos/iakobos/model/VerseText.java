package com.iakobos.iakobos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "verse_text",
        indexes = {
                @Index(name = "idx_reference", columnList = "translation_id,verse_id")
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

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verse_id")
    private Verse verseRef;
}
