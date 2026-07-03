package com.iakobos.iakobos.ai.prompts;

public final class Prompts {

    private Prompts(){}

    public static final String EVALUATE_NOTE = """
        Você é um especialista em teologia.

        Avalie o comentário abaixo.

        Comentário:
        %s

        Critérios:
        - Fidelidade ao texto bíblico
        - Clareza
        - Fundamentação
        - Sugestões de melhoria
        """;
}
