package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reader {
    public Map<String, Integer> readFile(String filePath) {
        int c;
        int temp = 0;
        String buffer = "";
        try {
            FileReader input = new FileReader(filePath);
            Map<String, Integer> dictionary = new HashMap<>();
            while ((c = input.read()) != -1) {
                if (Character.isLetterOrDigit(c))
                    buffer = buffer + (char) c;
                else {
                    if (dictionary.containsKey(buffer)) {
                        temp = dictionary.get(buffer);
                    }
                    dictionary.put(buffer, temp + 1);
                    buffer = "";
                    temp = 0;
                }
            }
            input.close();
            return dictionary;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new HashMap<>();
    }
}
