package com.iakobos.iakobos.dto;

/**
 * Versão enxuta do DTO de contexto usado pelo ChatController/IA.
 * Campos essenciais: tradução escolhida, referência do versículo, texto do verso
 * e conteúdo da nota que será avaliada.
 */
public record VerseContextDTO(
        Long translationId,
        Short bookId,
        Integer chapter,
        String verse,
        String verseText,
        String noteContent,
        String extraContext
) {}

