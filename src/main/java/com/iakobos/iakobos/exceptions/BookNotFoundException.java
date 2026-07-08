package com.iakobos.iakobos.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(Short id){
        super("Book not found with id: " + id);
    }

    public BookNotFoundException(String abbreviation){
        super("Book not found with abbreviation: " + abbreviation);
    }
}
