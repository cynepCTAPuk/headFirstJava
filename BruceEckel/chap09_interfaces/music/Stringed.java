package chap09_interfaces.music;

import static util.Print.*;

class Stringed extends Instrument implements Playable {
    public void play(Note n) { print("Stringed.play() " + n); }
    public String toString() { return "Stringed"; }
    public void adjust() { print("Stringed.adjust()");}
}
