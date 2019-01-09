package chap08.music;

import static util.Print.print;

class Brass extends Wind {
    public void play(Note n) { print("Brass.play() " + n); }
    public void adjust() { print("Brass.adjust()");}
}
