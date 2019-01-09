package chap08.music;

import static util.Print.*;

//: polymorphism/music/Wind.java
public class Percussion extends Instrument {
    // Redefine interface method:
    public void play(Note n) { System.out.println("Percussion.play() " + n); }
    public String what(Note n) { return "Percussion"; }
    public void adjust(Note n) { print("Percussion.adjust()");}
} ///:~