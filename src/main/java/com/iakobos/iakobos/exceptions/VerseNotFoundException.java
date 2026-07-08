package com.iakobos.iakobos.exceptions;

public class VerseNotFoundException extends RuntimeException{
    public VerseNotFoundException(Long id){
        super("Verse not found with id: " + id);
    }
}
