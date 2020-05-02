package algorithms;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class GenerateRandomIntArray {
    public static void main(String[] args) throws FileNotFoundException {
        new GenerateRandomIntArray().run();
    }

    private void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("c:/000/input.txt");
        int n = 100_000;
        Random random = new Random();

        printWriter.println(n);
        for (int i = 0; i < n; i++) printWriter.print(random.nextInt(1_000_000_000) + " ");
        printWriter.close();
    }
}
