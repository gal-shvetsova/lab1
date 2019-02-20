package com.company;

import java.io.IOException;
import java.io.InputStreamReader;

public interface Reader {
    String readWord(InputStreamReader stream) throws IOException;
}
