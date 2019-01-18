//: strings/IntegerMatch.java
package chap13_strings;
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-?\\d+");
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
        System.out.println("+911".matches("([-+])?\\d+")); // new
    }
} /* Output:
true
true
false
true
*///:~