package chap05;

//: initialization/SimpleConstructor.java
// Demonstration of a simple constructor.
class Rock {
    static int n = 0;

    Rock() { // This is the constructor
        System.out.print("Rock" + ++n+" ");
    }
}

public class SimpleConstructor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            new Rock();
    }
} /* Output:
Rock Rock Rock Rock Rock Rock Rock Rock Rock Rock
*///:~