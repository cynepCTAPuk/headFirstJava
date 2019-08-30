package chap08_Generic;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        ArrayList<String> passwords = new ArrayList<>() {
            public String get(int n) {
                return super.get(n)
                        .replace("p", "*")
                        .replace("r", "*")
                        .replace("i", "*")
                        .replace(".", "*");
            }

        };
        passwords.add("privet.");
        passwords.add(".rip");
        for (int i = 0; i < passwords.size(); i++) System.out.println(passwords.get(i));
    }
}
