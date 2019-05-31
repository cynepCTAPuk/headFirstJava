package src;

import java.util.*;

public class StringHelper {
    public static Set permutationFinder(String str) {
        Set<String> perm = new TreeSet<>();
        if (str == null) return null;
        if (str.length() == 0) { perm.add(""); return perm;}

        char initial = str.charAt(0); // первый символ
        String rem = str.substring(1); // полная строка без первого символа
        Set words = permutationFinder(rem);
        for (Object strNew : words) {
            for (int i = 0; i <= strNew.toString().length(); i++) {
                perm.add(charInsert((String) strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static void main(String[] args) {
        String s0 = "AAC";
        String s1 = "ABC";
        String s2 = "ABCD";
        String s3 = "123";
        System.out.printf("Permutation for %s are:\n%s\n", s0, permutationFinder(s0));
        System.out.printf("Permutation for %s are:\n%s\n", s1, permutationFinder(s1));
        System.out.printf("Permutation for %s are:\n%s\n", s2, permutationFinder(s2));
        System.out.printf("Permutation for %s are:\n%s\n", s3, permutationFinder(s3));
    }
}
