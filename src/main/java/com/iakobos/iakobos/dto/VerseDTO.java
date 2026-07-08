package com.iakobos.iakobos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VerseDTO(
        @NotNull Short bookId,
        @NotNull Integer chapter,
        @NotBlank String verse) {
}
