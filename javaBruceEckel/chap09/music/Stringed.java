package chap09.music;

import static util.Print.*;

class Stringed extends Instrument {
    public void play(Note n) { print("Stringed.play() " + n); }
    public String what() { return "Stringed"; }
    public void adjust() { print("Stringed.adjust()");}
}
