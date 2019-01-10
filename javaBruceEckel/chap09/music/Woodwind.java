package chap09.music;

import static util.Print.*;

class Woodwind extends Wind {
    public void play(Note n) { print("Woodwind.play() " + n); }
    public String toString() { return "Woodwind"; }
    public void adjust() { print("Woodwind.adjust()");}
}
