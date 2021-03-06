public class SimpleEncryption_1_AlternatingSplit {
    public static String encrypt(final String text, final int n) {
        String out = text;
        if (out == null) return null; //vk
        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 1; j < out.length(); j += 2) temp += out.charAt(j);
            for (int j = 0; j < out.length(); j += 2) temp += out.charAt(j);
            out = temp;
        }
        return out;
    }

    public static String decrypt(final String encryptedText, final int n) {
        String out = encryptedText;
        if (out == null) return null; //vk
        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < out.length() / 2; j += 1) {
                temp += "" + out.charAt(out.length() / 2 + j) + out.charAt(j);
            }
            out = temp + encryptedText.substring(encryptedText.length() / 2 * 2);
        }
        return out;
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