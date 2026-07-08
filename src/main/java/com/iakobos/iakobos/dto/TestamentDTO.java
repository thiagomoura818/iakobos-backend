package com.iakobos.iakobos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TestamentDTO(
        @NotNull Short id,
        @NotBlank String name) {
}
