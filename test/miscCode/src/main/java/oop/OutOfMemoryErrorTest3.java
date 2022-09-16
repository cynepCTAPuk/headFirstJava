package oop;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorTest3 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }
}
