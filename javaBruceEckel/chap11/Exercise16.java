package chap11;

import java.util.*;

public class Exercise16 {
    public static void main(String[] args) {
        String vowels = "a e i o u y";
        Set<String> setVowels = new HashSet<>();
        setVowels.addAll(Arrays.asList(vowels.split(" ")));
        System.out.println(setVowels);
    }
}
