package puzzle_33;

public class LooperMeetsWolfman {
    public static void main(String[] args) {
        // Place your declaration for i here
//        int i = Integer.MIN_VALUE;
        long i = Long.MIN_VALUE;
        while (i != 0 && i == -i) {
            System.out.println("Got it!");
            break;
        }
    }
}
