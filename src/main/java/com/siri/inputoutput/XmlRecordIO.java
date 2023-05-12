package com.siri.inputoutput;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.siri.creditcard.CARDS;
import com.siri.creditcard.CreditCard;
import com.siri.creditcard.CreditCardFactory;
import com.siri.creditcard.OutputRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class XmlRecordIO implements RecordIO {

    @Override
    public List<CreditCard> read(String filename) {
        List<CreditCard> records = new ArrayList<>();
        File file = new File(filename);
        try (Reader reader = new FileReader(file)) {
            MappingIterator<CreditCard> mi = getXmlReader().readValues(reader);
            while (mi.hasNext()) {
                CreditCard current = mi.next();
                records.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public boolean write(String filename, List<CreditCard> inputRecords) {
        File file = new File(filename);
        List<OutputRecord> outputRecordList = getOutputRecords(inputRecords);
        CARDS CARDS = new CARDS(outputRecordList);
        try {
            XmlMapper xmlMapper = getXmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(file, CARDS);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private XmlMapper getXmlMapper() {
        XmlMapper mapper = new XmlMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return mapper;
    }

    private ObjectReader getXmlReader() {
        return getXmlMapper().readerFor(CreditCard.class);
    }

    private List<OutputRecord> getOutputRecords(List<CreditCard> creditCards) {
        return creditCards
                .stream()
                .map(record -> {
                    String cardNumber = record.getCardNumber();
                    try {
                        String cardType = new CreditCardFactory().getCreditCard(cardNumber).toString();
                        return new OutputRecord(cardNumber, cardType);
                    } catch (UnsupportedOperationException e) {
                        return new OutputRecord(cardNumber,"Unsupported Card Type");
                    }
                })
                .collect(Collectors.toList());
    }
}
