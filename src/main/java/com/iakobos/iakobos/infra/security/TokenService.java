package com.iakobos.iakobos.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.iakobos.iakobos.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final SecurityProperties securityProperties;

    public String generateToken(User user) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(securityProperties.token().secret());
            return JWT.create()
                    .withIssuer(securityProperties.token().issuer())
                    .withSubject(user.getEmail())
                    .withClaim("role", user.getRole().name())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
        }catch(JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    public Optional<DecodedJWT> validateToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(securityProperties.token().secret());
            DecodedJWT jwt = JWT.require(algorithm)
                    .withIssuer(securityProperties.token().issuer())
                    .build()
                    .verify(token);
            return Optional.of(jwt);
        }catch (JWTVerificationException exception){
            return Optional.empty();
        }
    }

    private Instant genExpirationDate() {
        var expirationDuration = securityProperties.token().expiration();
        if (expirationDuration == null) {
            expirationDuration = java.time.Duration.ofHours(2); // Default fallback: 2 hours
        }
        return Instant.now().plus(expirationDuration);
    }
}
