package ru.isands.elreg.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
    }

    public BadRequestException(String msg) {
        super(msg);
    }
}
