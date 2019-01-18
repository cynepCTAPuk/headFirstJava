package chap04_control;

//: control/ForEachString.java
public class ForEachString {
    public static void main(String[] args) {
        String string = "An African Swallow";
        for(char c : string.toCharArray() ) System.out.print(c + " ");
    }
} /* Output:
A n A f r i c a n S w a l l o w
*///:~