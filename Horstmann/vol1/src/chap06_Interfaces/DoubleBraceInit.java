package chap06_Interfaces;

import java.util.ArrayList;

public class DoubleBraceInit {
    public static void main(String[] args) {
        invite(new ArrayList<>() {{
            add("Harry");
            add("Tony");
            add("Mary");
        }});
    }

    static void invite(ArrayList<String> list) {
        System.out.println(list);
    }
}
