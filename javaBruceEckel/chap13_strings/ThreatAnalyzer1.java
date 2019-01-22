//: strings/ThreatAnalyzer.java
package chap13_strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.*;

public class ThreatAnalyzer1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/000/threadData.txt"));
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