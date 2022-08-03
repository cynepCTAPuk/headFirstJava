package org.stepic.java.streamchars;

import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.StringTokenizer;

public class TokenizerTest {
    public static void main(String[] args) {
        StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader("Hello World!"));

        StringTokenizer stringTokenizer = new StringTokenizer("Hello World");
    }
}
