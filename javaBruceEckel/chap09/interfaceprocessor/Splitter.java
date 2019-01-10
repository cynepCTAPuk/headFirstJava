package chap09.interfaceprocessor;

import java.util.*;

class Splitter extends StringProcessor {
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}