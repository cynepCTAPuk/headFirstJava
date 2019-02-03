//: io/DirList.java
// Display a directory listing using regular expressions.
// {Args: "D.*\.java"}
package util;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class DirList {
    public static void main(String[] args) {
        String dir = ".";
        File path = new File(dir);
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
//        for(String dirItem : list) System.out.println(dirItem);
//        System.out.println(Arrays.toString(list));
        for (int i = 0; i < list.length; i++) {
            System.out.printf("%-24s ", list[i]);
            if (i % 3 == 2) System.out.println();
        }
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex) { pattern = Pattern.compile(regex); }
    public boolean accept(File dir, String name) { return pattern.matcher(name).matches(); }
} /* Output:
DirectoryDemo.java
DirList.java
DirList2.java
DirList3.java
*///:~