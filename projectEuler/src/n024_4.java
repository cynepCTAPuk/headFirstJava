import java.util.ArrayList;
import java.util.List;

/**
 * Lexicographic permutations
 * Problem 24
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * <p>
 * TheBestMigs Thu, 4 Jul 2019, 13:44
 */
public class n024_4 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int CombNum = 1; // Number of possible digit arrangements
        int position = 1000000;
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //list of digits availiable
        String answer = "";
        //Started by calculating the number of combinations possible
        for (int i = 10; i > 1; i--) {
            CombNum *= i;
        }
        List<Integer> used = new ArrayList<>(); //list of digits used
        for (int i = 10; i >= 1; i--) {
            //Finding the next digit
            int index = position / (CombNum / i);
            if (position % (CombNum / i) == 0) {
                index--;
            }
            int counter = 0;
            int PreIndex = index;
            for (int j = 0; j < used.size(); j++) {
                if (index >= used.get(j)) {
                    counter++;
                }
            }
            while (counter > 0) {
                index++;
                counter--;
                if (used.contains(index)) {
                    counter++;
                }
            }
            answer += nums[index];
            used.add(nums[index]);
            CombNum /= i;
            position -= CombNum * PreIndex;
        }
        System.out.println(answer);
        System.out.printf("Took %d ms %n", System.currentTimeMillis() - start);
    }
}