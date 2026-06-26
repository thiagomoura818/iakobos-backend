package com.iakobos.iakobos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateVerseNoteDTO(
        @NotNull Long id,
        @NotBlank String content
) {
}
