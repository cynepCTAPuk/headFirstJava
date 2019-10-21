import java.util.ArrayList;
import java.util.Collections;

/**
 * Lexicographic permutations
 * Problem 24
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * Junglemath Wed, 18 Sep 2019, 22:32
 */
public class n024_2 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.createArray(10);
        calculator.permutationCalculator(1000000);
    }
}

class Calculator {

    private ArrayList<Integer> numbers; // stores the numbers {n-1, ..., 2, 1} for input n
    private String permutation;         // permutation of interest
    private int initialSizeOfNumbers;   // size of the set {n, n-1, ..., 2, 1}

    Calculator() {
        this.numbers = new ArrayList<>();
        this.permutation = "";          // permutations will be built from an empty String
        this.initialSizeOfNumbers = 0;  // used for calculating the factorial necessary at each step
    }

    /**
     * create an ArrayList that stores {n-1, ..., 2, 1} for input n
     *
     * @param n number of letters to be permuted
     */
    void createArray(int n) {
        for (int i = (n - 1); i >= 0; i--)
            this.numbers.add(i);
        this.initialSizeOfNumbers = n - 1;
    }

    /**
     * calculates the permutation that corresponds to a number k, where 1 <= k <= n!
     *
     * @param target the number whose corresponding permutation is sought
     */
    void permutationCalculator(int target) {
        int i = this.initialSizeOfNumbers;
        while (this.numbers.size() >= 1) {                  //if this.numbers is not empty then we have not finished writing the permutation
            int factorialI = this.factorialCalculator(i);
            int quotient = target / (factorialI);           // divide target by the appropriate factorial to get a quotient
            int remainder = target % (factorialI);          // and remainder

            if (remainder != 0) { // if remainder != 0 then we must be in the next block
                this.permutation = this.permutation + this.numbers.get(this.numbers.size() - quotient - 1); //get the number that is the (quotient + 1)st
                //number in the ArrayList that has not yet been used in the permutation

                this.deleteEntry(this.numbers.get(this.numbers.size() - quotient - 1)); //delete the number that was just added to the permutation
            } else if (remainder == 0 && quotient != 0) { //this means that we are in the (quotient)th block
                this.permutation = this.permutation + this.numbers.get(this.numbers.size() - quotient); //so we get the number that is quotienth position from the right
                this.deleteEntry(this.numbers.get(this.numbers.size() - quotient)); //and delete the number just added to the permutation
            } else { //if both quotient and remainder are zero, then we must be at the permutation we wanted, so just add the remaining numbers to the p
                // permutation by decreasing size
                while (this.numbers.size() >= 1) {
                    int max = Collections.max(this.numbers);
                    this.permutation = this.permutation + max;
                    this.deleteEntry(max); //delete each number as it is added to the permutation
                }
                break;
            }
            target = remainder; //reset the target and repeat
            i--; //used to calculate the factorial in the next iteration
        }

        this.getPermutation(); //prints the permutation we wanted
        this.resetPermutation(); //used if wanted more than one permutation at once,
        //e.g. if all 4! permutations on 4 letters are wanted
    }

    /**
     * calculates n!
     *
     * @param n integer whose factorial is sought
     * @return n!
     */
    int factorialCalculator(int n) {
        int product = 1;
        for (int i = 2; i <= n; i++) {
            product = product * i;
        }
        return product;
    }

    /**
     * deletes the given number from the ArrayList
     *
     * @param i integer to be deleted
     */
    void deleteEntry(int i) {
        this.numbers.remove(this.numbers.indexOf(i));
    }

    /**
     * gets the last permutation calculated
     */
    void getPermutation() {
        System.out.println(this.permutation);
    }

    /**
     * resets the permutation to the empty String
     */
    void resetPermutation() {
        this.permutation = "";
    }

}
