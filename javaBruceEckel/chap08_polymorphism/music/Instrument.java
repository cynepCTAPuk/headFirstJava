package chap08_polymorphism.music;

import static util.Print.print;

//: polymorphism/music/Instrument.java
class Instrument {
    public void play(Note n) {
        print("Instrument.play()");
    }
    public String what() { return "Instrument"; }
    public void adjust() { print("Instrument.adjust()");}
}
///:~