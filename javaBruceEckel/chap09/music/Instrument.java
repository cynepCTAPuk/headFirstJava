package chap09.music;

import static util.Print.print;

abstract class Instrument {
    public void play(Note n) { System.out.println("Playable.play() " + n); }
    public String toString() { return "Playable"; }
    public void adjust() { print("Playable.adjust()");}

}
