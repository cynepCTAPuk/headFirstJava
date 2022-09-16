package string;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RandomString {
    public static void main(String[] args) {
        givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect();
    }
    private static void givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
        byte[]array = new byte[7];//length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.ISO_8859_1);

        System.out.println(generatedString);
    }
}
