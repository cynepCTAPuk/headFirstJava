package org.stepic.java.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
/*
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = reader.readLine();
            String[] array = string.split(" ");
            Stack<Integer> stack = new Stack<>();
            for (int i = 1; i < array.length; i = i + 2) {
                stack.push(Integer.parseInt(array[i]));
            }
            while (!stack.empty()) {
                System.out.print(stack.pop() + " ");
            }
        } catch (Exception e) {
        }
*/
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner("1 2 3 4 5 6 7 8 9 10 11 12 13");
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        int i, j = 0;
        while (scanner.hasNext()) {
            j++;
            i = scanner.nextInt();
            if ((j % 2) == 0) arrayDeque.addFirst(i);

        }
        for (Integer integer : arrayDeque) {
            System.out.print(integer + " ");
        }
    }
}
