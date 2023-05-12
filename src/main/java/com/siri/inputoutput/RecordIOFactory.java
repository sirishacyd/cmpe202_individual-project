package com.siri.inputoutput;

public class RecordIOFactory {
    public RecordIO getRecordIO(String filename) {
        if (filename.endsWith(".csv")) {
            return new CsvRecordIO();
        } else if (filename.endsWith(".json")) {
            return new JsonRecordIO();
        } else if (filename.endsWith(".xml")) {
            return new XmlRecordIO();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}