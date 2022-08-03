package shortPuzzles;

public class Logarithm {
    public static void main(String[] args) {
        System.out.println(log(9, 2));
        System.out.println(pow(2, 3));
        System.out.println(binlog(1025));
        System.out.println(log2nlz(1025));
    }

    static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    static int pow(int base, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) result *= base;
        return result;
    }

    static int binlog(int bits) {
        int log = 0;
        if ((bits & 0xffff0000) != 0) {
            bits >>>= 16;
            log = 16;
        }
        if (bits >= 256) {
            bits >>>= 8;
            log += 8;
        }
        if (bits >= 16) {
            bits >>>= 4;
            log += 4;
        }
        if (bits >= 4) {
            bits >>>= 2;
            log += 2;
        }
        return log + (bits >>> 1);
    }

    static int log2nlz(int bits) {
        if (bits == 0) return 0;
        return 31 - Integer.numberOfLeadingZeros(bits);
    }
}
