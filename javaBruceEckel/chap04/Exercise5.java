package chap04;

public class Exercise5 {
    public static void main(String[] args) {
        int number = pow(2, 0);
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
        int temp = number;
        if (temp == 0) binary += 0;
        while (temp > 0) {
            binary = (temp % 2) + binary;
            temp = temp / 2;
        }
/*
        while (temp > 0) {
            binary = oddeven(temp, binary);
            temp = temp / 2;
        }
*/
/*
        while (temp > 0) {  // it works!
            if (temp % 2 == 0) binary = 0 + binary;
            else binary = 1 + binary;
            temp = temp / 2;
        }
*/
/*
        while (temp < 0) { // should be done!!!
            if (temp % 2 == 0) binary = 0 + binary;
            else binary = 1 + binary;
            temp = temp / 2;
        }
*/
        return binary;
    }

    static int pow(int base, int exp) {
        if (exp < 0) return -1;
        if (exp == 0) return 1;
        return pow(base, exp - 1) * base;
    }
}
