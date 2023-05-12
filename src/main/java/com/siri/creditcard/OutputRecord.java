package com.siri.creditcard;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class OutputRecord {

    @JacksonXmlProperty(localName = "CARD_NUMBER")
    private String cardNumber;
    @JacksonXmlProperty(localName = "CARD_TYPE")
    private String cardType;

    public OutputRecord(String cardNumber, String cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setcardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}