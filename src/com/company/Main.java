package com.company;

public class Main {

    public static void main(String[] args) {
        CSVParser parser = new CSVParser("in.txt", "out.txt");
        parser.parse();
    }
}
