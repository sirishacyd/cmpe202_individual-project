package com.siri.creditcard;

public class AmExCC extends CreditCard {

    @Override
    public String toString() {
        return "AmericanExpress";
    }

    public static boolean isValid(String cardNumber) {
        return cardNumber.length() == 15 &&
                cardNumber.charAt(0) == '3' &&
                (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7');
    }
}
