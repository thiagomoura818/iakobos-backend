package com.iakobos.iakobos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Versão enxuta do DTO de contexto usado pelo ChatController/IA.
 * Campos essenciais: tradução escolhida, referência do versículo, texto do verso
 * e conteúdo da nota que será avaliada.
 */
public record VerseContextDTO(
        @NotNull Long translationId,
        @NotNull Short bookId,
        @NotNull Integer chapter,
        @NotBlank String verse,
        @NotBlank String verseText,
        @NotBlank String noteContent,
        @NotBlank String extraContext
) {}

