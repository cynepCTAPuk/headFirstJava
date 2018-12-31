package chap04;

public class Exercise5 {
    public static void main(String[] args) {
        int number = pow(2, 0)-6;
        for (int i = 0; i < 11; i++) {
            System.out.format("%32s ", toBinary(number));
            System.out.format("%32s %4d\n", Integer.toBinaryString(number), number);
            number++;
        }
    }

    private static String oddeven(int temp, String binary) {
        return temp % 2 == 0 ? 0 + binary : 1 + binary;
    }

    static String toBinary(int number) {
        String binary = "";
<<<<<<< HEAD
        for (int i = 2; i < number; i++)

            if (number / i == 0) binary = "1" + binary;
            else binary = "0" + binary;
        System.out.format("%3d = %10s\n", number, binary);
=======
        if (number == 0) binary += 0;
        while (number > 0) {
            binary = (number % 2) + binary;
            number = number / 2;
        }
/*
        while (nubmer > 0) {
            binary = oddeven(nubmer, binary);
            nubmer = nubmer / 2;
        }
*/
/*
        while (nubmer > 0) {  // it works!
            if (nubmer % 2 == 0) binary = 0 + binary;
            else binary = 1 + binary;
            nubmer = nubmer / 2;
        }
*/
/*
        while (nubmer < 0) { // should be done!!!
            if (nubmer % 2 == 0) binary = 0 + binary;
            else binary = 1 + binary;
            nubmer = nubmer / 2;
        }
*/
        return binary;
>>>>>>> f11cd12460c1655ff2ca103d373182a91a8ca8b9
    }

    private static int pow(int base, int exp) {
        if (exp < 0) return -1;
        if (exp == 0) return 1;
        return pow(base, exp - 1) * base;
    }
}
