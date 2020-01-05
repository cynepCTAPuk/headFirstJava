package print;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream("c:/000/printStream.txt");

        printStream.println("Hello!");
        printStream.println("I'm robot!");
        printStream.printf("My name is %s, my age is %d!", "Amigo", 18);

        printStream.close();
    }
}
