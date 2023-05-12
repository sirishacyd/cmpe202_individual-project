package com.siri.creditcard;

public class CreditCardFactory {
    public CreditCard getCreditCard(String cardNumber) {

        if (MasterCC.isValid(cardNumber)) {
            return new MasterCC();
        } else if (VisaCC.isValid(cardNumber)) {
            return new VisaCC();
        } else if (AmExCC.isValid(cardNumber)) {
            return new AmExCC();
        } else if (DiscoverCC.isValid(cardNumber)) {
            return new DiscoverCC();
        } else {
            if (cardNumber == null || cardNumber.isEmpty()) {
                return new ErrorMessage("Invalid: empty/null card number");
            }
            if (!cardNumber.matches("\\d+")) {
                return new ErrorMessage("Invalid: non numeric characters");
            }
            if (cardNumber.length() > 19) {
                return new ErrorMessage("Invalid: more than 19 digits");
            }
            return new ErrorMessage("Invalid: not a possible card number");
        }
    }
}
