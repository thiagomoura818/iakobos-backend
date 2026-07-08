package com.iakobos.iakobos.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank String token) {
}
