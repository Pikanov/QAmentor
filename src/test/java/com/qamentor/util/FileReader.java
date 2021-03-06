package com.qamentor.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

    public static Properties readPropertiesFile() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            System.err.println("properties file not found");
        }
        return properties;
    }
}
