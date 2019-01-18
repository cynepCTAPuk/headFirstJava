package chap09_interfaces.music;

import static util.Print.*;

public class Wind implements Playable {
    public void play(Note n) { System.out.println("Wind.play() " + n); }
    public String toString() { return "Wind"; }
    public void adjust() { print("Wind.adjust()");}
} ///:~