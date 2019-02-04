//: generics/BankTeller.java
// A very simple bank teller simulation.
package chap15_generics;

import util.*;

import java.util.*;

class LittleFish {
    private static long counter = 1;
    private final long id = counter++;
    private LittleFish() {}
    public String toString() { return "LittleFish " + id; }
    // A method to produce Generator objects:
    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            public LittleFish next() { return new LittleFish(); }
        };
    }
}

class BigFish {
    private static long counter = 1;
    private final long id = counter++;
    private BigFish() {}
    public String toString() { return "BigFish " + id; }
    // A single Generator object:
    public static Generator<BigFish> generator = new Generator<BigFish>() {
                public BigFish next() { return new BigFish(); }
            };
}

public class Ocean {
    public static void serve(BigFish b, LittleFish l) {
        System.out.println(b + " eat " + l);
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<LittleFish> line = new LinkedList<>();
        Generators.fill(line, LittleFish.generator(), 15);
        List<BigFish> tellers = new ArrayList<>();
        Generators.fill(tellers, BigFish.generator, 4);
        for(LittleFish l : line)
            serve(tellers.get(rand.nextInt(tellers.size())), l);
    }
} /* Output:
Teller 3 serves Customer 1
Teller 2 serves Customer 2
Teller 3 serves Customer 3
Teller 1 serves Customer 4
Teller 1 serves Customer 5
Teller 3 serves Customer 6
Teller 1 serves Customer 7
Teller 2 serves Customer 8
Teller 3 serves Customer 9
Teller 3 serves Customer 10
Teller 2 serves Customer 11
Teller 4 serves Customer 12
Teller 2 serves Customer 13
Teller 1 serves Customer 14
Teller 1 serves Customer 15
*///:~