package com.iakobos.iakobos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    private Short id;

    @ManyToOne
    @JoinColumn(name="testament_id", nullable = false)
    private Testament testament;

    @Column(nullable=false)
    private String name;

    private String abbreviation;

    private Short position;
}

