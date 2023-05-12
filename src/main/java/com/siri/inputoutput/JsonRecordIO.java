package com.siri.inputoutput;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.siri.creditcard.CreditCard;
import com.siri.creditcard.CreditCardFactory;
import com.siri.creditcard.OutputRecord;
import com.fasterxml.jackson.databind.node.ArrayNode;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class JsonRecordIO implements RecordIO {

    @Override
    public List<CreditCard> read(String filename) {
        List<CreditCard> records = new ArrayList<>();
        File file = new File(filename);
        try (Reader reader = new FileReader(file)) {
            JsonNode jsonNode = getJsonMapper().readTree(reader);
            JsonNode cardsNode = jsonNode.get("cards");
            if (cardsNode.isArray()) {
                Iterator<JsonNode> cardIterator = cardsNode.elements();
                while (cardIterator.hasNext()) {
                    JsonNode cardNode = cardIterator.next();
                    CreditCard current = getJsonReader().readValue(cardNode);
                    records.add(current);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public boolean write(String filename, List<CreditCard> records) {
        File file = new File(filename);
        List<OutputRecord> outputRecordList = getOutputRecords(records);
        ObjectMapper mapper = getJsonMapper();
        ObjectNode rootNode = mapper.createObjectNode();
        ArrayNode cardsArray = rootNode.putArray("cards");
        for (OutputRecord outputRecord : outputRecordList) {
            ObjectNode cardNode = mapper.createObjectNode();
            cardNode.put("cardNumber", outputRecord.getCardNumber() != null ? outputRecord.getCardNumber() :null);
            cardNode.put("CardType", outputRecord.getCardType() != null ? outputRecord.getCardType() : "");
            cardsArray.add(cardNode);            
        }
        try {
            mapper.writeValue(file, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private ObjectReader getJsonReader() {
        return getJsonMapper().readerFor(CreditCard.class);
    }

    private JsonMapper getJsonMapper() {
        JsonMapper mapper = new JsonMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }

    private List<OutputRecord> getOutputRecords(List<CreditCard> creditCards) {
        return creditCards
                .stream()
                .map(record -> {
                    String cardNumber = record.getCardNumber();
                    if (cardNumber != null) {
                        try {
                            return new OutputRecord(
                                    cardNumber,
                                    new CreditCardFactory().getCreditCard(cardNumber).toString());
                        } catch (UnsupportedOperationException e) {
                            return new OutputRecord(
                                    cardNumber,
                                    "Unsupported Card Type"
                            );
                        }
                    } else {
                        return new OutputRecord(
                                null,
                                "Invalid: empty/null card number"
                        );
                    }
                })
                .collect(Collectors.toList());
    }
    
}
