package com.siri.creditcard;

public class ErrorMessage extends CreditCard {
    private final String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}