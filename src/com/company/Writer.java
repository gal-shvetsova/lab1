package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Writer {
    public void writeFile(Parser parser) {
        try {
            FileWriter output = new FileWriter("/home/galya/ru/nsu/ccfit/shvetsova/lab1/src/lab1/out.txt");
            List<Map.Entry> v = parser.sort();
            double percentage;
            for (Map.Entry entry : v) {
                percentage = Double.parseDouble(entry.getValue().toString());
                percentage = percentage / parser.getCount() * 100.0;
                output.write(entry.getKey() + "," + entry.getValue() + "," + percentage + '\n');
            }
            output.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
