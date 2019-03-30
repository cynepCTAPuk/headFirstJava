/*
  5 - enum
  9 - exports, module, requires
  10 - var
  Total = 57 (include
  literal values - false, null, true
  unused = const, goto)
*/
import java.util.*;

public class ReservedWords {
    static final String keywords[] = {
            "abstract", "assert",
            "boolean", "break", "byte",
            "case", "catch", "char", "class", "const", "continue",
            "default", "do", "double",
            "else", "enum", "exports", "extends",
            "false", "final", "finally", "float", "for",
            "goto",
            "if", "implements", "import", "instanceof", "int", "interface",
            "long",
            "module",
            "native", "new", "null",
            "package", "private", "protected", "public",
            "requires", "return",
            "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "true", "try",
            "var", "void", "volatile",
            "while"};

    public static boolean isJavaKeyword(String keyword) {
        return (Arrays.binarySearch(keywords, keyword) >= 0);
    }

    //Main method
    public static void main(String[] args) {
        System.out.println(isJavaKeyword("void"));
//        System.out.println(Arrays.toString(keywords));
        System.out.println(keywords.length);
    }
}
