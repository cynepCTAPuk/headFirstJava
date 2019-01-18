package chap09_interfaces;

//: interfaces/RandVals.java
// Initializing interface fields with
// non-constant initializers.
import java.util.*;

import static util.Print.print;
import static util.Print.printf;

public interface RandVals {
    Random RAND = new Random(47);
    int RANDOM_INT = RAND.nextInt(10);
    long RANDOM_LONG = RAND.nextLong() * 10;
    float RANDOM_FLOAT = RAND.nextLong() * 10;
    double RANDOM_DOUBLE = RAND.nextDouble() * 10;

    static void main(String[] args) {
        print(RANDOM_INT);
        printf("%,d\n",RANDOM_LONG);
        print(RANDOM_FLOAT);
        print(RANDOM_DOUBLE);
    }
} ///:~