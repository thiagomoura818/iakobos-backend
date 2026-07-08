package com.iakobos.iakobos.exceptions;

public class VerseNoteNotFoundException extends RuntimeException{

    public VerseNoteNotFoundException(Long id){
        super("Verse note not found with id: " + id);
    }

    public VerseNoteNotFoundException(){
        super("Verse note not found");
    }
}
