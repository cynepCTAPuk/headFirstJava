public class Tweedledee {
    public static void main(String[] args) {
        // Put your declarations for x and i here
        double x = 1; // vk
        char i = 'a'; // vk

        System.out.format("char i = 'a';\t-> %3d%n", (int)i);

        x = x + i;  // Must be LEGAL
        System.out.format("x = x + i;\t\t-> %3.0f%n", x);

        x += i;     // Must be ILLEGAL
        System.out.format("x += i;\t\t\t-> %3.0f%n", x);
    }
}
