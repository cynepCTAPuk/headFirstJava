package string;

import java.util.HashSet;
import java.util.Set;

/**
 * http://www.cyberforum.ru/java-j2se/thread1783280.html
 */
public class Permutations3 {
    public static Set<String> set = new HashSet();

    public static void Rearrange(String prefix, String str) {
        set.add(prefix);
        for (char ch : str.toCharArray())
            Rearrange(prefix + ch, str.replaceFirst(ch + "", ""));
    }

    public static void main(String[] args) {
        Rearrange("", "123");
        System.out.println(set);

    }
}