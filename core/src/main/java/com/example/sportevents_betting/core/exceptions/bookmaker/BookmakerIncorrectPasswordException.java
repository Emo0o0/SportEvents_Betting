package com.example.sportevents_betting.core.exceptions.bookmaker;

public class BookmakerIncorrectPasswordException extends RuntimeException{
    public BookmakerIncorrectPasswordException(String message) {
        super(message);
    }
}
