package ru.isands.elreg.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }

    public NotFoundException(String msg) {
        super(msg);
    }
}
