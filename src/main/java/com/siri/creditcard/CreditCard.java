package com.siri.creditcard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class CreditCard {
    @JacksonXmlProperty(localName = "CARD_NUMBER")
    @JsonProperty("cardNumber")
    private String cardNumber;

    @JacksonXmlProperty(localName = "EXPIRATION_DATE")
    @JsonProperty("expirationDate")
    private String expirationDate;

    @JacksonXmlProperty(localName = "CARD_HOLDER_NAME")
    @JsonProperty("cardHolderName")
    private String cardHolderName;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}