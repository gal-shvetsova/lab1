package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

public class fileWriter implements Writer{
    @Override
    public void writeString(OutputStreamWriter stream, String string) throws IOException {
        stream.write(string);
    }
}
