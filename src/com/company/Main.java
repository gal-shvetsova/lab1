package com.company;

public class Main {

    public static void main(String[] args) {
        CSVParser parser = new CSVParser(new Reader().readFile("in.txt"));
        Writer writer = new Writer();
        writer.writeFile(parser);
    }
}
