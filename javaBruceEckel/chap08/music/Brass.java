package chap08.music;

import static util.Print.print;

class Brass extends Instrument {
    public void play(Note n) { print("Brass.play() " + n); }
}
