package com.iakobos.iakobos.exceptions;

public class TranslationNotFoundException extends RuntimeException{
    public TranslationNotFoundException(Short id){
        super("Translation not found with id: " + id);
    }

    public TranslationNotFoundException(String abbreviation){
        super("Translation not found with abbreviation: " + abbreviation);
    }
}
