package com.iakobos.iakobos.model.dto.VerseText;

public record VerseTextResponse(Long id, Short translationId, Short bookId, Integer chapter, String verse, String text) {
}
