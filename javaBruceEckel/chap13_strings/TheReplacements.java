//: strings/TheReplacements.java
package chap13_strings;
import java.util.regex.*;
import util.*;
import static util.Print.*;
/*! Here’s a block of text to use as input to
the regular expression matcher. Note that we’ll
first   extract the block of text by looking for
the special delimiters, then process the
extracted block. !*/
public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.read("chap13_strings/TheReplacements.java");
        // Match the specially commented block of text above:
        Matcher mInput = Pattern.compile(
                "/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if (mInput.find()) s = mInput.group(1); // Captured by parentheses
        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");
        // Replace one or more spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
//        print("1--\n" + s);
//        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]\\w");
        Matcher m = p.matcher(s);
        // Process the find information as you
        while (m.find()) m.appendReplacement(sbuf, m.group().toUpperCase());
        m.appendTail(sbuf); // Put in the remainder of the text:
        print("2--\n" + sbuf);
    }
} /* Output:
Here’s a block of text to use as input to
the regular expression matcher. Note that we’ll
first extract the block of text by looking for
the special delimiters, then process the
extracted block.
H(VOWEL1)rE’s A blOck Of tExt tO UsE As InpUt tO
thE rEgUlAr ExprEssIOn mAtchEr. NOtE thAt wE’ll
fIrst ExtrAct thE blOck Of tExt by lOOkIng fOr
thE spEcIAl dElImItErs, thEn prOcEss thE
ExtrActEd blOck.
*///:~