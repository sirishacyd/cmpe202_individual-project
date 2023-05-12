package com.siri;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class UtilsTest {

    @Test
    public void test_validateFileExtension_doesNotThrowOnValidExtensions() {
        Utils.validateFileExtension("input_file-1.csv", "output.csv");
    }

    @Test
    public void test_validateFileExtension_throwsErrorOnInvalidExtensions() {
        assertThrows(RuntimeException.class, () -> Utils.validateFileExtension("input_file-1.json", "output.csv"));
    }

    @Test
    public void test_validateInputPathExists_doesNotThrowOnValidPath() {
        Utils.validateInputPathExists("src/main/resources/input_file-1.csv");
    }

    @Test
    public void test_validateInputPathExists_throwsOnInvalidPath() {
        assertThrows(RuntimeException.class, () -> Utils.validateInputPathExists("input1_file-1.csv"));
    }
}