package com.iakobos.iakobos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateVerseNoteDTO(
        @NotBlank String content,
        @NotNull Long verseId
) {
}
