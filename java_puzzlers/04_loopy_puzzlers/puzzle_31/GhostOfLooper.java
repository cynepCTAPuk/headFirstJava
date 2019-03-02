package puzzle_31;

public class GhostOfLooper {
    public static void main(String[] args) {
        // Place your declaration for i here
//        byte i = -1;
        short i = -1;
        while (i != 0) {
            i >>>= 1;
            System.out.printf("(%,d) ", i);
//            break;
        }
    }
}
