package com.siri;

import com.siri.creditcard.CreditCard;
import com.siri.inputoutput.RecordIO;
import com.siri.inputoutput.RecordIOFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Invalid syntax. Usage: java Main <input filename> <output filename>");
            System.exit(1);
        }

        String inputFilename = args[0];
        String outputFilename = args[1];
        Utils.validatePaths(inputFilename, outputFilename);
        RecordIO io = new RecordIOFactory().getRecordIO(inputFilename);
        List<CreditCard> creditCards = io.read(inputFilename);
        boolean writeSuccess = io.write(outputFilename, creditCards);
        if (writeSuccess) {
            System.out.println("Output successfully written to " + outputFilename);
        } else {
            System.out.println("Failed to write output");
        }
    }
}