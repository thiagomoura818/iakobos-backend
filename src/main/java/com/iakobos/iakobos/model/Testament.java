package com.iakobos.iakobos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="testament")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Testament {

    @Id
    private Short id;

    @Column(nullable = false, length = 50)
    private String name;
}
