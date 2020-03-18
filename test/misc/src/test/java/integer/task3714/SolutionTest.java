package integer.task3714;

import org.junit.Assert;
import org.junit.Test;

import static integer.task3714.Solution.romanToInteger;
import static integer.task3714.Solution.toArabic;

public class SolutionTest {
    @Test
    public void testRomanToInteger() {
        Assert.assertEquals(romanToInteger("IV"), 4);
        Assert.assertEquals(romanToInteger("VI"), 6);
        Assert.assertEquals(romanToInteger("VIII"), 8);
        Assert.assertEquals(romanToInteger("IX"), 9);
        Assert.assertEquals(romanToInteger("XV"), 15);
        Assert.assertEquals(romanToInteger("XIX"), 19);
        Assert.assertEquals(romanToInteger("XL"), 40);
        Assert.assertEquals(romanToInteger("XLII"), 42);
        Assert.assertEquals(romanToInteger("LX"), 60);
        Assert.assertEquals(romanToInteger("LXXX"), 80);
        Assert.assertEquals(romanToInteger("LXXXIII"), 83);
        Assert.assertEquals(romanToInteger("XCIV"), 94);
        Assert.assertEquals(romanToInteger("XC"), 90);
        Assert.assertEquals(romanToInteger("CL"), 150);
        Assert.assertEquals(romanToInteger("CCLXXXIII"), 283);
        Assert.assertEquals(romanToInteger("DCCC"), 800);
        Assert.assertEquals(romanToInteger("MCMLXXXVIII"), 1988);
        Assert.assertEquals(romanToInteger("MMDCLXXXIII"), 2683);
        Assert.assertEquals(romanToInteger("MMDDCCLLXXVVII"), 3332);
        Assert.assertEquals(romanToInteger("MMMD"), 3500);
    }

    @Test
    public void testToArabic() {
        Assert.assertEquals(toArabic("IV"), 4);
        Assert.assertEquals(toArabic("VI"), 6);
        Assert.assertEquals(toArabic("VIII"), 8);
        Assert.assertEquals(toArabic("IX"), 9);
        Assert.assertEquals(toArabic("XV"), 15);
        Assert.assertEquals(toArabic("XIX"), 19);
        Assert.assertEquals(toArabic("XL"), 40);
        Assert.assertEquals(toArabic("XLII"), 42);
        Assert.assertEquals(toArabic("LX"), 60);
        Assert.assertEquals(toArabic("LXXX"), 80);
        Assert.assertEquals(toArabic("LXXXIII"), 83);
        Assert.assertEquals(toArabic("XCIV"), 94);
        Assert.assertEquals(toArabic("XC"), 90);
        Assert.assertEquals(toArabic("CL"), 150);
        Assert.assertEquals(toArabic("CCLXXXIII"), 283);
        Assert.assertEquals(toArabic("DCCC"), 800);
        Assert.assertEquals(toArabic("MCMLXXXVIII"), 1988);
        Assert.assertEquals(toArabic("MMDCLXXXIII"), 2683);
        Assert.assertEquals(toArabic("MMDDCCLLXXVVII"), 3332);
        Assert.assertEquals(toArabic("MMMD"), 3500);
    }
}