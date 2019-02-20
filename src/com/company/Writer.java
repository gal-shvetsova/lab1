package com.company;

import java.io.IOException;
import java.io.OutputStreamWriter;

public interface Writer  {
    void writeString(OutputStreamWriter stream, String string) throws IOException;
}
