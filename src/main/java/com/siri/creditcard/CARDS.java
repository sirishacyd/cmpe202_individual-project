package com.siri.creditcard;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class CARDS {

    @JacksonXmlProperty(localName = "CARD")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<OutputRecord> cards;

    public CARDS(List<OutputRecord> cards) {
        this.cards = cards;
    }

    public List<OutputRecord> getCards() {
        return cards;
    }

    public void setCards(List<OutputRecord> cards) {
        this.cards = cards;
    }
}
