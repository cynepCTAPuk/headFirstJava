package puzzle_30;

public class SonOfLooper {
    public static void main(String[] args) {
        // Place your declaration for i here
        String i = "Buy seventeen copies of Effective Java!";
        while (i != i + 0) {
            System.out.println("Got it!");
            break;
        }
    }
}
