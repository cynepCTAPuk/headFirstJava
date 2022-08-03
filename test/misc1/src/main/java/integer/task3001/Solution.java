package integer.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

        number = new Number(NumberSystemType._8, "100");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._10);
        System.out.println(result);    //expected 3

    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        //напишите тут ваш код
/*
        String sDigit = number.getDigit();
        int sNumberSystemType = number.getNumberSystem().getNumberSystemIntValue();
        String digits = "0123456789abcdef".substring(0, sNumberSystemType);
        for (int i = 0; i < sDigit.length(); i++) {
            if (!digits.contains(sDigit.substring(i, i + 1))) throw new NumberFormatException();
        }

        long longNum = Long.parseLong(sDigit, sNumberSystemType);
        int radix = expectedNumberSystem.getNumberSystemIntValue();
        String xNum = Long.toUnsignedString(longNum, radix);

        NumberSystemType type = null;
        for (NumberSystemType n : NumberSystemType.values()) {
            if (radix == n.getNumberSystemIntValue()) type = n;
        }
        return new Number(type, xNum);
*/
        String sDigit = number.getDigit();
        int sNumberSystemType = number.getNumberSystem().getNumberSystemIntValue();
        int radix = expectedNumberSystem.getNumberSystemIntValue();

        String digits = "0123456789abcdef".substring(0, sNumberSystemType);
        for (int i = 0; i < sDigit.length(); i++) {
            if (!digits.contains(sDigit.substring(i, i + 1))) throw new NumberFormatException();
        }

        BigInteger input = new BigInteger(sDigit, sNumberSystemType);
        NumberSystemType type = null;
        for (NumberSystemType n : NumberSystemType.values()) {
            if (radix == n.getNumberSystemIntValue()) type = n;
        }

        return new Number(type, input.toString(radix));
/*
        BigInteger bi = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        String ans = bi.toString(expectedNumberSystem.getNumberSystemIntValue());
        return new Number(expectedNumberSystem, ans);
*/
    }
}

