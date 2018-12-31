package chap04;

public class Exercise5 {
    public static void main(String[] args) {
        int number = pow(2, 1) + pow(2, 2) + pow(2, 5);
        System.out.format("%3d = %10s\n", number, Integer.toBinaryString(number));
        toBinary(4);
    }

    static void toBinary(int number) {
        String binary = "";
        for (int i = 2; i < number; i++)

            if (number / i == 0) binary = "1" + binary;
            else binary = "0" + binary;
        System.out.format("%3d = %10s\n", number, binary);
    }

    static int pow(int base, int exp) {
        if (exp < 0) return -1;
        if (exp == 0) return 1;
        return pow(base, exp - 1) * base;
    }

}
