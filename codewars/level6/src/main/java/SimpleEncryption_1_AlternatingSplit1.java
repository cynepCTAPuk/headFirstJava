public class SimpleEncryption_1_AlternatingSplit1 {
    public static String encrypt(final String text, final int n) {
        String result = text;
        if (result == null) return null;
        int m = n;
        while (m-- > 0) {
            String first = "", second = "";
            char[] chars = result.toCharArray();
            for (int i = 0; i < chars.length; i += 2) {
                first += chars[i];
                if (i + 1 < chars.length) second += chars[i + 1];
            }
            result = second + first;
        }
        return result;
    }

    public static String decrypt(final String encryptedText, final int n) {
        String result = encryptedText;
        if (result == null) return null;
        int m = n;
        int length = result.length();
        while (m-- > 0) {
            String second = result.substring(0, length / 2);
            String first = result.substring(length / 2, length);
            char[] chars = new char[length];
            for (int i = 0; i < chars.length; i += 2) {
                chars[i] = first.charAt(i / 2);
                if (i + 1 < chars.length) chars[i + 1] = second.charAt(i / 2);
            }
            result = String.valueOf(chars);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("This is a test!", 0));
        System.out.println(encrypt("This is a test!", 1));
        System.out.println(encrypt("This is a test!", 2));
        System.out.println(encrypt("This is a test!", 3));
        System.out.println(encrypt("This is a test!", 4));
        System.out.println(encrypt("This is a test!", -1));
        System.out.println(encrypt("This kata is very interesting!", 1));
        System.out.println(encrypt("", 1));
        System.out.println();
        System.out.println(decrypt("This is a test!", 0));
        System.out.println(decrypt("hsi  etTi sats!", 1));
        System.out.println(decrypt("s eT ashi tist!", 2));
        System.out.println(decrypt(" Tah itse sits!", 3));
        System.out.println(decrypt("This is a test!", 4));
        System.out.println(decrypt("This is a test!", -1));
        System.out.println(decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
        System.out.println(decrypt(null, 1));
    }
}