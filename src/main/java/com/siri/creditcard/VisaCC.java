package com.siri.creditcard;

public class VisaCC extends CreditCard {

    @Override
    public String toString() {
        return "Visa";
    }

    public static boolean isValid(String cardNumber) {
        return cardNumber.length() == 13 ||
                cardNumber.length() == 16 &&
                        cardNumber.charAt(0) == '4';
    }
}
