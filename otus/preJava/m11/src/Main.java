import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //byte, short, int, long
        //boolean, char, float, double

        // &, |, ^
        // <<, >>, >>>, ~

        // &&, ||, !
        // ==, !=, >, <, <=, >=

        // if, else, else if, switch
        // for, while, do while

        int a;
        System.out.println("Enter number:");
        Scanner scanner = new Scanner(System.in);
        try {
            a = scanner.nextInt();
        } finally {
            scanner.close();
        }
        printBinary(a,8);
    }

    private static void printBinary(long value, int size) {
        for (int i = size - 1; i >= 0; i--) {
            long mask = 1L << i;
            long result = (mask & value) >> i;
            System.out.print(result);
        }
//        System.out.println(Long.toBinaryString(value));
    }
}