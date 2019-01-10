package chap09.music;

import static util.Print.*;

//: polymorphism/music/Instrument.java
abstract class Instrument {
    private int i; // Storage allocated for each
    public abstract void play(Note n);
    public String what() { return "Instrument"; }
    public abstract void adjust();
}