package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CSVParser {
    private Map<String, Integer> dictionary;
    private FileReader in;
    private FileWriter out;

    public CSVParser(String inFilePath, String outFilePath) {
        this.dictionary = new HashMap<>();
        try {
            this.in = new FileReader(inFilePath);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        try {
            this.out = new FileWriter(outFilePath);
        } catch (IOException ex) {
            System.out.println();
        }
    }

    public void parse() {
        fileReader reader = new fileReader();
        try {
            String word = reader.readWord(in);
            int temp = 0;
            while (!word.equals("")) {
                if (dictionary.containsKey(word)) {
                    temp = dictionary.get(word);
                }
                dictionary.put(word, temp + 1);
                word = reader.readWord(in);
                temp = 0;
            }
            in.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        double count = getCount();
        List<Map.Entry> list = sort();
        fileWriter writer = new fileWriter();
        try {
            String string;
            double percentage;
            for (Map.Entry entry : list) {
                string = "";
                percentage = Double.parseDouble(entry.getValue().toString());
                percentage = percentage / count * 100.0;
                string = entry.getKey() + "," + entry.getValue() + "," + percentage + '\n';
                writer.writeString(out, string);

            }
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private double getCount() {
        int count = 0;
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            count += entry.getValue();
        }
        return count;
    }


    private List<Map.Entry> sort() {
        return dictionary.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
    }

}