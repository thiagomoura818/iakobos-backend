package com.iakobos.iakobos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VerseNoteDTO(
        @NotNull Long id,
        @NotBlank String content,
        @NotNull Long verseId) {
}
