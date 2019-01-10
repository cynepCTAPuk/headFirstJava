package chap09.music;

import static util.Print.*;

public class Percussion extends Instrument implements Playable {
    public void play(Note n) { System.out.println("Percussion.play() " + n); }
    public String toString() { return "Percussion"; }
    public void adjust() { print("Percussion.adjust()");}
} ///:~