package com.iakobos.iakobos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="verse_note")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerseNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="verse_id", nullable = false)
    private Verse verse;

}
