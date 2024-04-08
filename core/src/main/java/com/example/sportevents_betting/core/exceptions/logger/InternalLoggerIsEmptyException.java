package com.example.sportevents_betting.core.exceptions.logger;

public class InternalLoggerIsEmptyException extends RuntimeException {
    public InternalLoggerIsEmptyException(String message) {
        super(message);
    }
}
