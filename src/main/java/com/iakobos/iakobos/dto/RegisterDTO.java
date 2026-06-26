package com.iakobos.iakobos.dto;

import com.iakobos.iakobos.model.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String password,
        @NotNull UserRole role
) {
}
