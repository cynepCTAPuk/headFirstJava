package chap08.music;

import static util.Print.print;

//: polymorphism/music/Wind.java
// Wind objects are instruments
// because they have the same interface:
public class Wind extends Instrument {
    // Redefine interface method:
    public void play(Note n) { System.out.println("Wind.play() " + n); }
    public String what(Note n) { return "Wind"; }
    public void adjust(Note n) { print("Wind.adjust()");}
} ///:~