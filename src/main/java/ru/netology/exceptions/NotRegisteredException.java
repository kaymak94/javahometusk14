package ru.netology.exceptions;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String msg) {
        super(msg);
    }
}
