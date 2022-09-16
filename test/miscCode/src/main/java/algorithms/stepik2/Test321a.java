package algorithms.stepik2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test321a {
    public static String[] phonebook = new String[10_000_000];
    public static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= num; i++) {
            String[] request = reader.readLine().split(" ");
            int number = Integer.parseInt(request[1]);
            switch (request[0]) {
                case "add":
                    add(number, request[2]);
                    break;
                case "find":
                    find(number);
                    break;
                case "del":
                    del(number);
            }
        }
        System.out.println(result.toString());
    }

    static void add(int number, String name) {
        phonebook[number] = name;
    }

    static void find(int number) {
        if (phonebook[number] != null) {
            result.append(phonebook[number]);
        } else {
            result.append("not found");
        }
        result.append("\n");
    }

    static void del(int number) {
        phonebook[number] = null;
    }
}