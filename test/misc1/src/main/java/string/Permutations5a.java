package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations5a {

    public static void collect(Set<List<String>> set, List<String> list) {
        if (list.size() == 0) return;
        set.add(list);
        for (String s : list) {
            List<String> copy = new ArrayList<>(list);
            copy.remove(s);
            collect(set, copy);
        }
    }

    public static void main(String[] args) {
        Set<List<String>> set = new HashSet();
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) list.add(String.valueOf(i));
        System.out.println(list);
        collect(set, list);
        System.out.println(set.size());
        for (List<String> l : set) System.out.println(l);
    }
}