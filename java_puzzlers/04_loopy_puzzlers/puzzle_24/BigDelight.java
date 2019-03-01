package puzzle_24;
class BigDelight {
    public static void main(String[] args) {
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == 0x90) System.out.print("Joy!");
        }

        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == (byte) 0x90) System.out.print("Joy!");
        }
        System.out.println();
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if ((b & 0xff) == 0x90) System.out.print("Joy!");
        }
        System.out.println();
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++)
            if (b == TARGET) System.out.print("Joy!");
    }
    private static final byte TARGET = (byte) 0x90; // Broken!
}
