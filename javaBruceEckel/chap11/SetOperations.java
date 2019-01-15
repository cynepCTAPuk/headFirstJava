package chap11;

//: holding/SetOperations.java

import java.util.*;

import static util.Print.*;

public class SetOperations {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Collections.addAll(set1, "A B C D E F G H I J K L".split(" "));
        set1.add("M");
        print("H: " + set1.contains("H"));
        print("N: " + set1.contains("N"));

        Set<String> set2 = new HashSet<>();
        Collections.addAll(set2, "H I J K L".split(" "));
        print("set2 in set1: " + set1.containsAll(set2));
        set1.remove("H");
        print("set1: " + set1);
        print("set2 in set1: " + set1.containsAll(set2));
        set1.removeAll(set2);
        print("set2 removed from set1: " + set1);
        Collections.addAll(set1, "X Y Z".split(" "));
        print("X Y Z added to set1: " + set1);

        String[] strings = "X 3 | 0 A B C D E FF G H II J K L".split(" ");
        System.out.println("strings " + Arrays.toString(strings));

        Set<String> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(strings));
        System.out.println("hashSet " + hashSet);

        Set<String> test = new TreeSet<>(hashSet);
        System.out.println("testSet " + test);

        Set<String> treeSet = new TreeSet<>();
        treeSet.addAll(Arrays.asList(strings));
        System.out.println("treeSet " + treeSet);
    }
} /* Output:
H: true
N: false
set2 in set1: true
set1: [D, K, C, B, L, G, I, M, A, F, J, E]
set2 in set1: false
set2 removed from set1: [D, C, B, G, M, A, F, E]
‘X Y Z’ added to set1: [Z, D, C, B, G, M, A, F, Y, X, E]
*///:~