package com.endava.demo.exception;

public class SupermarketAlreadyExistException extends RuntimeException{
    public SupermarketAlreadyExistException(String name) {
        super("Supermarket with name: " + name);
    }
}