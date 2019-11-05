package chap03;

import chap03_streams.StringToStreamDemo;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringToStreamTest {
    private StringToStreamDemo demo = new StringToStreamDemo();

    @Test
    public void isPalindrome() {
        assertTrue(Stream.of(
                "Madam, in Eden, I’m Adam",
                "Go hang a salami; I’m a lasagna hog",
                "Flee to me, remote elf!",
                "A Santa pets rats as Pat taps a star step at NASA")
                .allMatch(demo::isPalindrome));
        assertFalse(demo.isPalindrome("Это НЕ палиндром"));
    }
}
