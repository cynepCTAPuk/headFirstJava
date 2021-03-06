package chap09_interfaces.music;

//: polymorphism/music/Music1.java
// Inheritance & upcasting.
public class Music1 {
    public static void tune(Playable i) { i.play(Note.MIDDLE_C); }
    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // Upcasting
    }
} /* Output:
Wind.play() MIDDLE_C
*///:~