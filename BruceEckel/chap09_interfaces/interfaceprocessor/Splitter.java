package chap09_interfaces.interfaceprocessor;

import java.util.*;

class Splitter extends StringProcessor {
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}