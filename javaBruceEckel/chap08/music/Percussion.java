package chap08.music;

import static util.Print.*;

//: polymorphism/music/Wind.java
public class Percussion extends Instrument {
    // Redefine interface method:
    public void play(Note n) { System.out.println("Percussion.play() " + n); }
    public String what() { return "Percussion"; }
    public void adjust() { print("Percussion.adjust()");}
} ///:~