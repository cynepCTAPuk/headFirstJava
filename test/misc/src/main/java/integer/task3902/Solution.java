package integer.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Биты были биты
*/
public class Solution {
    public static void main(String[] args) throws IOException {
/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("The entered number has " + result + "ones");
*/
        int start = 1024;
        for (int i = start; i < start + 5; i++) {
            System.out.println(isWeightEven(i));
        }
    }

    public static boolean isWeightEven(long number) {
        System.out.print(Long.toBinaryString(number) + ":");
/*
        String s = Long.toBinaryString(number);
        int result = 0;
        for (char c : s.toCharArray())
            if (c == '1')
                result++;
        return result % 2 == 0;
*/
//        return Long.bitCount(number) % 2 == 0;
        int result = 0;
        int count=0;
        while (number != 0) {
            count++;
            result += number & 1;
            number = number >>> 1;
        }
        System.out.print(result + ":" + count+":");
        return result % 2 == 0;
/*
        int result = 0;
        while (number != 0) {
            result++;
            number = number & (number - 1);
        }
        System.out.print(result + ":");
        return result % 2 == 0;
*/
    }
}
