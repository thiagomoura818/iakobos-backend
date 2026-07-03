package com.iakobos.iakobos.ai;

import com.iakobos.iakobos.ai.prompts.PromptsFactory;
import com.iakobos.iakobos.dto.VerseContextDTO;
import com.iakobos.iakobos.model.VerseNote;
import com.iakobos.iakobos.model.VerseText;
import com.iakobos.iakobos.repository.VerseTextRepository;
import com.iakobos.iakobos.service.VerseNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerseNoteAIService {

    private final ChatClient chatClient;
    private final VerseNoteService verseNoteService;
    private final PromptsFactory promptsFactory;
    private final VerseTextRepository verseTextRepository;

    public String evaluate(Long verseNoteId){
        // default evaluation without explicit translation: use the note content and verse reference
        VerseNote verseNote = verseNoteService.getVerseNoteById(verseNoteId);
        String prompt = promptsFactory.buildEvaluationPrompt(verseNote);
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    public String evaluate(Long verseNoteId, Short translationId){
        VerseNote verseNote = verseNoteService.getVerseNoteById(verseNoteId);

        // try to fetch verse text for the requested translation
        VerseText vt = null;
        if (translationId != null){
            vt = verseTextRepository.findByTranslationIdAndVerseId(translationId, verseNote.getVerse().getId()).orElse(null);
        }

        String verseText = vt != null ? vt.getText() : null;

        // build prompt manually including verse text and note content
        StringBuilder prompt = new StringBuilder();
        prompt.append("Você é um especialista em teologia. Avalie a nota/observação do usuário com base no verso fornecido.\n\n");
        prompt.append("Referência: ").append(verseNote.getVerse().getBook().getName())
                .append(" ").append(verseNote.getVerse().getChapter()).append(":")
                .append(verseNote.getVerse().getVerse()).append("\n");
        if (verseText != null) {
            prompt.append("Verso (tradução ").append(translationId).append("): ").append(verseText).append("\n\n");
        }
        prompt.append("Nota do usuário: ").append(verseNote.getContent()).append("\n\n");
        prompt.append("Critérios de avaliação: fidelidade ao texto, clareza, fundamentação e sugestões de melhoria. Informe também um score 0-100.\n");

        return chatClient.prompt()
                .user(prompt.toString())
                .call()
                .content();
    }


}
