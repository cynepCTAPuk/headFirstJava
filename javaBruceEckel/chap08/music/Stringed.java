package chap08.music;

import static util.Print.print;

class Stringed extends Instrument {
    public void play(Note n) { print("Stringed.play() " + n); }
    public String what(Note n) { return "Stringed"; }
    public void adjust(Note n) { print("Stringed.adjust()");}
}
