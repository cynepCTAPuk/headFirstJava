//: strings/ThreatAnalyzer.java
package chap13_strings;

import java.util.*;
import java.util.regex.*;

public class ThreatAnalyzer1 {
    static String threatData =
            "58.27.82.161@02/10/2005\n" +
                    "204.45.234.40@02/11/2005\n" +
                    "58.27.82.161@02/11/2005\n" +
                    "58.27.82.161@02/12/2005\n" +
                    "58.27.82.161@02/12/2005\n" +
                    "[Next log section with different data format]";
    public static void main(String[] args) {
        Scanner scanner = new Scanner("C:/000/threadData.txt");
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" + "(\\d{2}/\\d{2}/\\d{4})";
        while(scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult matcher = scanner.match();
            String ip = matcher.group(1);
            String date = matcher.group(2);
            System.out.format("Threat on %s from %s\n", date,ip);
        }
    }
} /* Output:
Threat on 02/10/2005 from 58.27.82.161
Threat on 02/11/2005 from 204.45.234.40
Threat on 02/11/2005 from 58.27.82.161
Threat on 02/12/2005 from 58.27.82.161
Threat on 02/12/2005 from 58.27.82.161
*///:~