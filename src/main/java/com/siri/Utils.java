package com.siri;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class Utils {
    public static void validatePaths(String inputPath, String outputPath) {
        validateInputPathExists(inputPath);
        validateFileExtension(inputPath, outputPath);
    }

    public static void validateInputPathExists(String inputPath) {
        File file = new File(inputPath);
        if (!file.isFile()) {
            throw new RuntimeException("Input path does not exist");
        }
    }

    public static void validateFileExtension(String inputPath, String outputPath) {
        String inputExtension = FilenameUtils.getExtension(inputPath);
        String outputExtension = FilenameUtils.getExtension(outputPath);
        if (!inputExtension.equals(outputExtension)) {
            throw new RuntimeException("Input and output extensions should be the same");
        }
    }
}