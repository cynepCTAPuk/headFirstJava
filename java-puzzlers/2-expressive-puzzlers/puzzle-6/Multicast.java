public class Multicast {
    public static void main(String[] args) {
        System.out.println((int) (char) (byte) -1);

        System.out.println(Integer.toBinaryString((byte) -1));
        System.out.println(Integer.toBinaryString((char) (byte) -1));
        System.out.println(Integer.toBinaryString((int) (char) (byte) -1));
        System.out.println(Integer.toBinaryString(65535));
        System.out.println((1 << 16) - 1);
    }
}
