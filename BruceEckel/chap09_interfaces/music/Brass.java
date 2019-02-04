package chap09_interfaces.music;

import static util.Print.*;

class Brass extends Wind {
    public void play(Note n) { print("Brass.play() " + n); }
    public String toString() { return "Brass"; }
    public void adjust() { print("Brass.adjust()");}
}
