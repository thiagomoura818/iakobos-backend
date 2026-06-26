package com.iakobos.iakobos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "verse",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "book_id",
                                "chapter",
                                "verse_number"
                        }
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Verse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="book_id")
    private Book book;

    private Integer chapter;

    private String verse;
}
