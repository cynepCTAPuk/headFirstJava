package chap09.interfaceprocessor;

//: interfaces/interfaceprocessor/Apply.java

import static util.Print.*;

public class Apply {
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
} ///:~