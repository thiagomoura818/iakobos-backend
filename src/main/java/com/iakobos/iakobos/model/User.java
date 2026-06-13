package com.iakobos.iakobos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length = 100, nullable = false)
    private String name;

    @Column(name="login", length = 100, nullable = false, unique = true)
    private String login;

    @Column(name="email", length=10, nullable = false, unique = true)
    private String email;

}
