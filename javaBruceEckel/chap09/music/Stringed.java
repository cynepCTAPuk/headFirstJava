package chap09.music;

import static util.Print.*;

class Stringed extends Base implements Instrument {
    public void play(Note n) { print("Stringed.play() " + n); }
    public String toString() { return "Stringed"; }
    public void adjust() { print("Stringed.adjust()");}
}
