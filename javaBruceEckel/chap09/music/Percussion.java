package chap09.music;

import static util.Print.*;

//: polymorphism/music/Wind.java
public class Percussion implements Instrument {
    public void play(Note n) { System.out.println("Percussion.play() " + n); }
    public String toString() { return "Percussion"; }
    public void adjust() { print("Percussion.adjust()");}
} ///:~