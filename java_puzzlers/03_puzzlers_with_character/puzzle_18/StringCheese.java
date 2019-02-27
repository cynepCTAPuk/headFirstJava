public class StringCheese {
    public static void main(String args[]) {
        byte bytes[] = new byte[256];

        for(int i = 0; i < 256; i++) {
            bytes[i] = (byte)i;

            System.out.print((char)i);
            if(i%40==0) System.out.println();
        }

        System.out.println();
        System.out.println();
        String str = new String(bytes);

        for(int i = 0, n = str.length(); i < n; i++)
            System.out.print((int)str.charAt(i) + " ");
    }
}
