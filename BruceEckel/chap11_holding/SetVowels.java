package chap11_holding;

import java.util.*;

public class SetVowels {
    public static void main(String[] args) {
        String vowels = "a e i o u y A E I O U Y";
        Set<String> setVowels = new TreeSet<>();
        setVowels.addAll(Arrays.asList(vowels.split(" ")));
        System.out.println(setVowels);
    }
}
