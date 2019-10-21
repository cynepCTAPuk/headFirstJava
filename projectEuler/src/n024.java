import java.util.ArrayList;
import java.util.List;

/**
 * Lexicographic permutations
 * Problem 24
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * 2783915460 = 1_000_000 th element
 * 3628800 = All numbers
 */
public class n024 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String[] strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int n = strings.length;
        boolean[] bitMask = new boolean[n];
        for (int i0 = 0; i0 < n; i0++) {
            String result0;
            result0 = strings[i0];
            bitMask[i0] = true;
            for (int i1 = 0; i1 < n; i1++) {
                String result1;
                if (!bitMask[i1]) {
                    result1 = result0 + strings[i1];
                    bitMask[i1] = true;
                } else continue;
                for (int i2 = 0; i2 < n; i2++) {
                    String result2;
                    if (!bitMask[i2]) {
                        result2 = result1 + strings[i2];
                        bitMask[i2] = true;
                    } else continue;
                    for (int i3 = 0; i3 < n; i3++) {
                        String result3;
                        if (!bitMask[i3]) {
                            result3 = result2 + strings[i3];
                            bitMask[i3] = true;
                        } else continue;
                        for (int i4 = 0; i4 < n; i4++) {
                            String result4;
                            if (!bitMask[i4]) {
                                result4 = result3 + strings[i4];
                                bitMask[i4] = true;
                            } else continue;
                            for (int i5 = 0; i5 < n; i5++) {
                                String result5;
                                if (!bitMask[i5]) {
                                    result5 = result4 + strings[i5];
                                    bitMask[i5] = true;
                                } else continue;
                                for (int i6 = 0; i6 < n; i6++) {
                                    String result6;
                                    if (!bitMask[i6]) {
                                        result6 = result5 + strings[i6];
                                        bitMask[i6] = true;
                                    } else continue;
                                    for (int i7 = 0; i7 < n; i7++) {
                                        String result7;
                                        if (!bitMask[i7]) {
                                            result7 = result6 + strings[i7];
                                            bitMask[i7] = true;
                                        } else continue;
                                        for (int i8 = 0; i8 < n; i8++) {
                                            String result8;
                                            if (!bitMask[i8]) {
                                                result8 = result7 + strings[i8];
                                                bitMask[i8] = true;
                                            } else continue;
                                            for (int i9 = 0; i9 < n; i9++) {
                                                String result9;
                                                if (!bitMask[i9]) {
                                                    result9 = result8 + strings[i9];
                                                    bitMask[i9] = true;
                                                    list.add(result9);
                                                } else continue;
                                                bitMask[i9] = false;
                                            }
                                            bitMask[i8] = false;
                                        }
                                        bitMask[i7] = false;
                                    }
                                    bitMask[i6] = false;
                                }
                                bitMask[i5] = false;
                            }
                            bitMask[i4] = false;
                        }
                        bitMask[i3] = false;
                    }
                    bitMask[i2] = false;
                }
                bitMask[i1] = false;
            }
            bitMask[i0] = false;
        }
        for (int i = 0; i < 10; i++) System.out.print(list.get(i) + " ");
        System.out.println();
        for (int i = 10; i > 0; i--) System.out.print(list.get(list.size() - i) + " ");
        System.out.println();
        System.out.println(list.get(1_000_000 - 1));
        System.out.println(list.size());
    }
}
