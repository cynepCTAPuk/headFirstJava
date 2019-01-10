package chap09.music;

import static util.Print.*;

//: polymorphism/music/Wind.java
// Wind objects are instruments
// because they have the same interface:
public class Wind implements Instrument {
    // Redefine interface method:
    public void play(Note n) { System.out.println("Wind.play() " + n); }
    public String toString() { return "Wind"; }
    public void adjust() { print("Wind.adjust()");}
} ///:~