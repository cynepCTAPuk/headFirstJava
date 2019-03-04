public class UtilsConverter {
    static int number = 62;

    public static void main(String[] args) {
        System.out.println("Number " + number + " to binary " +
                decToBin(number) + " decToBin");
        System.out.println("Number " + number + " to binary " +
                intToString(number, 16, 4) + " inToString");
        System.out.println("Number " + number + " to binary " +
                toBinary(number, 8) + " toBinary");
        System.out.print("Number " + number + " to binary ");
        bitPattern(number, 16);
        System.out.print("Number " + number + " to binary ");
        toBase(number, 16, 2);

        System.out.println();
        System.out.print("Number " + number + " to binary " +
                Integer.toBinaryString(number) + " Integer.toBinaryString(" + number + ")");
    }

    public static String decToBin(int number) {
        StringBuilder sb = new StringBuilder();
        sb.append(number & 1);
        int i = 1, p = 0;
        while ((number >>= 1) != 0) {
            if (i++ % 4 == 0) {
                sb.append(" ");
                p++;
            }
            sb.append(number & 1);
        }
        return sb.reverse().toString();
    }

    public static String intToString(int number, int digits, int groupSize) {
        StringBuilder result = new StringBuilder();
        int n = digits - 1;
        for (int i = n; i >= 0; i--) {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");
            if (i % groupSize == 0) result.append(" ");
        }
        result.replace(result.length() - 1, result.length(), "");
        return result.toString();
    }

    public static String toBinary(int number, int bits) {
        if (--bits > 0) {
            return toBinary(number >> 1, bits) + ((number & 0x1) == 0 ? "0" : "1");
        } else {
            return (number & 0x1) == 0 ? "0" : "1";
        }
    }

    public static void bitPattern(int number, int digits) {
        int mask = 1 << digits - 1;
        int count = 0;
        while (mask != 0) {
            if ((mask & number) == 0) System.out.print("0");
            else System.out.print("1");
            if (count % 4 == 3) System.out.print(" ");
            count++;
            mask = mask >>> 1;
        }
        System.out.println("bitPattern");
    }

    public static void toBase(int number, int digits, int base) {
        String binary = "";
        int tmp = digits;
        for (int j = 0; j < tmp; j++) {
            if (j % 4 == 0) binary += " ";
            binary += "" + number % base;
            number /= base;
        }
        for (int j = binary.length() - 1; j >= 0; j--) {
            System.out.print(binary.charAt(j));
        }
        System.out.println("toBase");
    }
}