package chap09.music;

import static util.Print.*;

class Brass extends Wind {
    public void play(Note n) { print("Brass.play() " + n); }
    public String what() { return "Brass"; }
    public void adjust() { print("Brass.adjust()");}
}
