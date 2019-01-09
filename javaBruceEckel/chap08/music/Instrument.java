package chap08.music;

import static util.Print.print;

//: polymorphism/music/Instrument.java
class Instrument {
    public void play(Note n) {
        print("Instrument.play()");
    }
    public String what(Note n) { return "Instrument"; }
    public void adjust(Note n) { print("Instrument.adjust()");}
}
///:~