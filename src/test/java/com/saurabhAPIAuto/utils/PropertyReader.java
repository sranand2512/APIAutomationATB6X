package com.saurabhAPIAuto.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static String readKey(String key) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties")) {
            properties.load(fileInputStream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return properties.getProperty(key);
    }
}
