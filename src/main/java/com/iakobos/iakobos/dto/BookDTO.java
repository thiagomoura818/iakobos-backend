package com.iakobos.iakobos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDTO(
        @NotNull Short id,
        @NotNull Short testamentId,
        @NotBlank String name,
        @NotBlank String abbreviation,
        @NotNull Short position) {
}
