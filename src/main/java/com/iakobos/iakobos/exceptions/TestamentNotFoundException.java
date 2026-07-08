package com.iakobos.iakobos.exceptions;

public class TestamentNotFoundException extends RuntimeException{
    public TestamentNotFoundException(Short id){
        super("Testament not found with id: " + id);
    }
}
