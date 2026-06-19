package com.iakobos.iakobos.controller;

import com.iakobos.iakobos.infra.security.TokenService;
import com.iakobos.iakobos.model.User;
import com.iakobos.iakobos.model.UserRole;
import com.iakobos.iakobos.model.dto.AuthenticationRequest;
import com.iakobos.iakobos.model.dto.LoginResponse;
import com.iakobos.iakobos.model.dto.RegisterRequest;
import com.iakobos.iakobos.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid AuthenticationRequest data) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest data) {
        if (repository.existsByEmail(data.email()) || repository.existsByLogin(data.login())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        User newUser = new User();
        newUser.setName(data.name());
        newUser.setLogin(data.login());
        newUser.setEmail(data.email());
        newUser.setPassword(passwordEncoder.encode(data.senha()));
        newUser.setRole(UserRole.USER);

        repository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
