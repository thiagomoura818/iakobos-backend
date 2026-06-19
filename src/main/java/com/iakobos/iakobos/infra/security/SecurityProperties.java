package com.iakobos.iakobos.infra.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.List;

@ConfigurationProperties(prefix = "api.security")
public record SecurityProperties(
        Token token,
        Cors cors
) {
    public record Token(
            String secret,
            String issuer,
            Duration expiration
    ) {
    }

    public record Cors(
            List<String> allowedOrigins
    ) {
    }
}
