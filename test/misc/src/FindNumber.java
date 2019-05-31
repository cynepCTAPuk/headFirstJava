package src;//ЖОПА * ЖОПА = СЧАСТЬЕ

import static java.lang.Math.*;

public class FindNumber {
    public static void main(String[] args) {
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                if (b == a) continue;
                for (int c = 0; c <= 9; c++) {
                    if (c == a | c == b) continue;
                    for (int d = 0; d <= 9; d++) {
                        if (d == a | d == b | d == c) continue;
                        int result = a * 1000 + b * 100 + c * 10 + d;
                        int square = result * result;
                        String string = String.valueOf(square);
                        int[] number = new int[string.length()];
                        if (string.length() == 7) {
                            for (int i = 0; i < string.length(); i++)
                                number[i] = (int) (square / pow(10, string.length() - 1 - i) % 10);
                            if (number[0] == number[3] & number[2] == d) {
                                if (number[0] != a & number[0] != b & number[0] != c & number[0] !=
                                        d & number[0] != number[1] & number[0] !=
                                        number[2] & number[0] != number[4] & number[0] !=
                                        number[5] & number[0] != number[6]) {
                                    if (number[1] != number[2] & number[1] != number[3] & number[1] !=
                                            number[4] & number[1] != number[5] & number[1] != number[6]) {
                                        if (number[2] != number[3] & number[2] !=
                                                number[4] & number[2] != number[5] & number[2] !=
                                                number[6]) {
                                            if (number[3] != number[4] & number[3] !=
                                                    number[5] & number[3] != number[6]) {
                                                if (number[4] != number[5] & number[4] != number[6]) {
                                                    if (number[5] != number[6]) {
                                                        System.out.println(result + " - " + square + "  ");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

/*
    static int pow(int base, int exponent) {
        int result = 1;
        if (exponent < 0) return 0;
        for (int i = 0; i < exponent; i++) result *= base;
        return result;
    }
*/
}

