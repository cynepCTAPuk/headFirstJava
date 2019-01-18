package chap09_interfaces.music;

import static util.Print.*;

public class Music3 {
    // Doesn’t care about type, so new types
    // added to the system still work right:
    public static void tune(Playable i) { i.play(Note.MIDDLE_C); }
    public static void tuneAll(Playable[] e) {
        for(Playable i : e) tune(i);
    }
    public static void what(Playable i) { print(i.toString()); }
    public static void whatAll(Playable[] e) {
        for(Playable i : e) what(i);
    }
    public static void main(String[] args) {
// Upcasting during addition to the array:
        Playable[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
//        tuneAll(orchestra);
//        whatAll(orchestra);

        RandomInstumentGenerator rnd = new RandomInstumentGenerator();
        what(rnd.next());
        what(rnd.next());
        what(rnd.next());
    }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~