package chap07_reusing;

import static util.Print.*;
//: reusing/Wind.java
// Inheritance & upcasting.
class Instrument {
    public void play() {printnb("Play ");}
    static void tune(Instrument i) {
        print("Tune " + i);
        i.play();
    }
}

// Wind objects are instruments
// because they have the same interface:
public class Wind extends Instrument {
    public void play(){ super.play(); print("Wind");}
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute); // Upcasting
    }
} ///:~