package com.iakobos.iakobos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
<<<<<<< HEAD
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
=======
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7

@Entity
@Table(name="users")
@Getter
@Setter
<<<<<<< HEAD
public class User implements UserDetails {
=======
public class User {
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length = 100, nullable = false)
    private String name;

<<<<<<< HEAD
    @Column(name="email", length=100, nullable = false, unique = true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.getRole()));
    }

    @Override
    public String getPassword() { return this.password; }

    @Override
    public String getUsername() { return this.email; }
=======
    @Column(name="login", length = 100, nullable = false, unique = true)
    private String login;

    @Column(name="email", length=10, nullable = false, unique = true)
    private String email;

>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
