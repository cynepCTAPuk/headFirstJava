package chap09.music;

import static util.Print.print;

abstract class Base {
    public void play(Note n) { System.out.println("Instrument.play() " + n); }
    public String toString() { return "Instrument"; }
    public void adjust() { print("Instrument.adjust()");}

}
