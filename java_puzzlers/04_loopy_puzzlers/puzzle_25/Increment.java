package puzzle_25;

public class Increment {
    public static void main(String[] args) {
        int j = 0, k = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
            k = ++k;
        }
        System.out.println(j + " " + k);
    }
}
