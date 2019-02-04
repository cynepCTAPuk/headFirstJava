package chap09_interfaces.music;

//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.

import java.util.*;

public class RandomInstumentGenerator {
    private Random rand = new Random();
    public Playable next() {
        switch(rand.nextInt(5)) {
            default:
            case 0: return new Brass();
            case 1: return new Percussion();
            case 2: return new Stringed();
            case 3: return new Wind();
            case 4: return new Woodwind();
        }
    }
} ///:~