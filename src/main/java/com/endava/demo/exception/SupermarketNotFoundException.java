package com.endava.demo.exception;

public class SupermarketNotFoundException extends RuntimeException{
    public SupermarketNotFoundException(String message) {
        super(message);
    }
}