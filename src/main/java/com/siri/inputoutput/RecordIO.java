package com.siri.inputoutput;

import java.util.List;

import com.siri.creditcard.CreditCard;

public interface RecordIO {
    List<CreditCard> read(String filename);

    boolean write(String filename, List<CreditCard> records);
}