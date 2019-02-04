package chap11_holding;

//: holding/UniqueWords.java

import util.*;

import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(
                new TextFile("chap11_holding/SetOperations.java", "\\W+"));
        System.out.println(words);

        String vowels = "aeiouyAEIOUY";
        int countAll = 0;
        for (String string : words) {
            int count = 0;
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                for (int j = 0; j < vowels.length(); j++) {
                    char v = vowels.charAt(j);
                    if (v == c) {
                        count++;
                        countAll++;
                    }
                }
            }
            System.out.print("[" + string + ":" + count + "]");
        }
        System.out.println();
        System.out.print("All vowels = " + countAll);
    }
} /* Output:
[A, B, C, Collections, D, E, F, G, H, HashSet, I, J, K, L, M, N, Output, Print, Set, SetOperations, String, X, Y, Z, add, addAll, added, args, class, contains, containsAll, false, from, holding, import, in, java, main, mindview, net, new, print, public, remove, removeAll, removed, set1, set2, split, static, to, true, util, void]
*///:~