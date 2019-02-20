package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class fileReader implements Reader {

    @Override
    public String readWord(InputStreamReader stream) throws IOException{
        int letter = stream.read();
        String word = "";
        while (letter != -1 && Character.isLetterOrDigit(letter)) {
            word += (char)letter;
            letter = stream.read();
        }
        return word;
    }

}
