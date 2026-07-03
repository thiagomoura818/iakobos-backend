package com.iakobos.iakobos.ai.prompts;

import com.iakobos.iakobos.model.VerseNote;
import org.springframework.stereotype.Component;

@Component
public class PromptsFactory {

    public String buildEvaluationPrompt(VerseNote note){
        return Prompts.EVALUATE_NOTE.formatted(note.getContent());
    }
}
