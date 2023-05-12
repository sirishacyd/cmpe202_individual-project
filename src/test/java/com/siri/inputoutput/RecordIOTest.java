package com.siri.inputoutput;

import org.junit.Test;

import com.siri.creditcard.CreditCard;
import com.siri.inputoutput.RecordIO;
import com.siri.inputoutput.RecordIOFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecordIOTest {

    @Test
    public void test_readFromCsv() {
        String filename = "src/main/resources/input_file-1.csv";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5567894523129089", firstRecord.getCardNumber());
        assertEquals("08/26", firstRecord.getExpirationDate());
    }

    @Test
    public void test_readFromXml() {
        String filename = "src/main/resources/input_file.xml";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5567894523129089", firstRecord.getCardNumber());
        assertEquals("08/26", firstRecord.getExpirationDate());
    }

    @Test
    public void test_readFromJson() {
        String filename = "src/main/resources/input_file-1.json";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5567894523129089", firstRecord.getCardNumber());
        assertEquals("08/26", firstRecord.getExpirationDate());
    }
}
