package puzzle_9;

/*
 To avoid unpleasant surprises, do not use compound assignment operators
 on variables of type byte, short, or char.
 */
public class Tweedledum {
    public static void main(String[] args) {
        // Put your declarations for x and i here
        short x = 7;
        byte i = 7;
        x += i;     // Must be LEGAL
//        x = x + i;  // Must be ILLEGAL
    }
}
