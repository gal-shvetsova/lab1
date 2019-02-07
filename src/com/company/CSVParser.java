package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class CSVParser implements Parser {
    private Map<String, Integer> dictionary;

    public CSVParser(Map<String, Integer> dictionary) {
        this.dictionary = dictionary;
    }

    public double getCount() {
        int count = 0;
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            count += entry.getValue();
        }
        return count;
    }

    @Override
    public List<Map.Entry> sort() {
        return dictionary.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
    }

}