package com.example.sportevents_betting.core.exceptions.bookmaker;

public class BookmakerNotFoundException extends RuntimeException{
    public BookmakerNotFoundException(String message) {
        super(message);
    }
}
