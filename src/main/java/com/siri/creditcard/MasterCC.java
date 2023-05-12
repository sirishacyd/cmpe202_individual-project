package com.siri.creditcard;

public class MasterCC extends CreditCard {

    @Override
    public String toString() {
        return "MasterCard";
    }

    public static boolean isValid(String cardNumber) {
        return cardNumber.length() == 16 &&
                cardNumber.charAt(0) == '5' &&
                cardNumber.charAt(1) >= '1' &&
                cardNumber.charAt(1) <= '5';
    }
}
