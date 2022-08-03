package datatypes;

public class Literals {
    public static void main(String[] args) {
        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        float pi =  3.14_15F;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;

        System.out.println(creditCardNumber);
        System.out.println(socialSecurityNumber);
        System.out.println(pi);
        System.out.println(hexBytes);
        System.out.println(hexWords);
        System.out.println(maxLong);
        System.out.println(nybbles);
        System.out.println(bytes);
    }
}
