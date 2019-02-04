package chap03_operators;

public class Exercise11 {
    public static void main(String[] args) {
//        int i = (1 << 31) - 1;
//        int i = 0x10_00_00_00;
//        int i = 020_00_00_00_00;
//        int i = 268_435_456;
        int i = ((int) Math.pow(2, 30));
        String integString = Integer.toBinaryString(i);
        String octalString = Integer.toOctalString(i);
        String hexalString = Integer.toHexString(i);
        System.out.println(integString + " " + integString.length() + " " + i);
        System.out.println(octalString + " " + octalString.length() + " " + i);
        System.out.println(hexalString + " " + hexalString.length() + " " + i);
        for (int j = 0; j < 32; j++) {
            System.out.format("%,20d",i>>>j);
        }
    }
}
