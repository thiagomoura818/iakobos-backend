package com.iakobos.iakobos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VerseTextDTO(
        @NotNull Long id,
        @NotNull Short translationId,
        @NotNull Short bookId,
        @NotNull Integer chapter,
        @NotBlank String verse,
        @NotBlank String text) {
}
