package com.iakobos.iakobos.dto;

public record VerseTextDTO(Long id, Short translationId, Short bookId, Integer chapter, String verse, String text) {
}
