package com.iakobos.iakobos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TranslationDTO(
        @NotNull Short id,
        @NotBlank String name,
        @NotBlank String abbreviation,
        @NotBlank String language) {
}
