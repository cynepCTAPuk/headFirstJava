package chap09.music;

import static util.Print.*;

//: polymorphism/music/Wind.java
public class Percussion extends Instrument {
    public void play(Note n) { System.out.println("Percussion.play() " + n); }
    public String what() { return "Percussion"; }
    public void adjust() { print("Percussion.adjust()");}
} ///:~