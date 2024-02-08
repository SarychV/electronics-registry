package ru.isands.elreg.exception;

public class BadConditionException extends RuntimeException {

    public BadConditionException() {
    }

    public BadConditionException(String message) {
        super(message);
    }
}
