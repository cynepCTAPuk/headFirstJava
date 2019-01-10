package chap09.music;

public class Music5 {
// Doesn’t care about type, so new types
// added to the system still work right:
    static void tune(Playable i) { i.play(Note.MIDDLE_C); }
    static void tuneAll(Playable[] e) { for(Playable i : e) tune(i); }

    public static void main(String[] args) {
        Playable[] orchestra = { new Percussion(), new Stringed(),
                new Wind(), new Brass(), new Woodwind() };
        tuneAll(orchestra);
    }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~