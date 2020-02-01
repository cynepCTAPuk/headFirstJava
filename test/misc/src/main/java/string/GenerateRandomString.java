package string;
/**
 * https://www.baeldung.com/java-random-string
 */

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Random;

public class GenerateRandomString {
    public static void main(String[] args) {
//        givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect();
//        givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect();
        givenUsingJava8_whenGeneratingRandomAlphabeticString_thenCorrect();
        givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect();
        generateRandomString();
        generateRandomStringWithBigInteger(130);
//        for (Provider provider : Security.getProviders()) System.out.println(provider.getInfo());
    }

    public static void givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
        byte[] array = new byte[60]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        System.out.println(generatedString);
    }

    public static void givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 60;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        System.out.println(generatedString);
    }

    public static void givenUsingJava8_whenGeneratingRandomAlphabeticString_thenCorrect() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 60;
        Random random = new Random();
        String generatedString = random
                .ints(targetStringLength, leftLimit, rightLimit + 1)
//                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString);
    }

    public static void givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 60;
        Random random = new Random();
        String generatedString = random
                .ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString);
    }

    public static void generateRandomString() {
        SecureRandom secureRandom = new SecureRandom();
        int leftDigit = 48; // digit '0'
        int rightDigit = 58; // digit '9'
        int leftSmallLetter = 97; // letter 'a'
        int rightRightLetter = 122; // letter 'z'
        int stringLength = 60;
        StringBuilder builder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            int digitRange = rightDigit - leftDigit;
            int letterRange = rightRightLetter - leftSmallLetter;
            int rand = (int) (secureRandom.nextFloat() * (digitRange + letterRange + 1));

            if (rand < digitRange) rand = leftDigit + rand;
            else rand = leftSmallLetter - digitRange + rand;

            builder.append((char) rand);
        }
        System.out.println(builder.toString());
    }

    /**
     * параметр radix - система счисления
     * Base16 - символы 0-9 ,a-f
     * Base32 - символы a-z , 2-7 (Не используются цифры, слишком похожие на буквы (например, 0 похож на О, 1 на l)
     * Base36  - символы 0-9, a-z
     * Base64 - символы 0-9, A-Z, a-z  и два дополнительных символа
     * Base58 - Стандарт похож на Base64, но отличается тем,
     *  что в результатах нет не только служебных кодов, но и алфавитно-цифровых символов,
     *  которые могут человеком восприниматься неоднозначно.
     *  Исключены 0 (ноль), O (заглавная латинская o), I (заглавная латинская i),
     *  l (строчная латинская L). Также исключены символы + (плюс) и / (косая черта),
     *  которые при кодировании URL могут приводить к неверной интерпретации.
     * @param numBits
     */
    public static void generateRandomStringWithBigInteger(int numBits) {
        System.out.println( new BigInteger(numBits, new SecureRandom()).toString(36));
    }
}
