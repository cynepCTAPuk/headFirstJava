import java.util.*;

public class ReservedWords {
    static final String keywords[] = {
            "abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "false", "final", "finally",
            "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long",
            "native", "new", "null", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "true", "try",
            "void", "volatile", "while"};

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