package chap08.music;

import static util.Print.*;

class Woodwind extends Wind {
    public void play(Note n) { print("Woodwind.play() " + n); }
    public String what() { return "Woodwind"; }
    public void adjust() { print("Woodwind.adjust()");}
}
