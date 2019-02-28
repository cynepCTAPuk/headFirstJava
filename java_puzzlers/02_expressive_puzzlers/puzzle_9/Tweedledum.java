package puzzle_9;

public class Tweedledum {
    public static void main(String[] args) {
        // Put your declarations for x and i here
        byte x = 7; //  vk
        byte i = x; //  vk

        x += i;     // Must be LEGAL
//        x = x + i;  // Must be ILLEGAL
        System.out.println(x + " "+i);  //  vk
    }
}
