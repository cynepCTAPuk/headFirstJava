//: containers/Stacks.java
// Demonstration of Stack Class.
package chap17_containers;
import java.util.*;
import static util.Print.*;

enum Month { JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER }

public class Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for(Month m : Month.values()) stack.push(m.toString());
        print("stack = " + stack);
        // Treating a stack as a Vector:
        stack.addElement("The last line");
        print("element 5 = " + stack.elementAt(5));
        print("popping elements:");
        while(!stack.empty()) printnb(stack.pop() + " ");

        // Using a LinkedList as a Stack:
        LinkedList<String> linkedListStack = new LinkedList<>();
        for(Month m : Month.values()) linkedListStack.addFirst(m.toString());
        print("\n\nlinkedListStack = " + linkedListStack);
        while(!linkedListStack.isEmpty()) printnb(linkedListStack.removeFirst() + " ");

        // Using the Stack class from the Holding Your Objects Chapter:
        util.Stack<String> stack2 = new util.Stack<>();
        for(Month m : Month.values()) stack2.push(m.toString());
        print("\n\nstack2 = " + stack2);
        while(!stack2.empty()) printnb(stack2.pop() + " ");
    }
} /* Output:
stack = [JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER]
element 5 = JUNE
popping elements:
The last line NOVEMBER OCTOBER SEPTEMBER AUGUST JULY JUNE MAY APRIL MARCH FEBRUARY JANUARY lstack = [NOVEMBER, OCTOBER, SEPTEMBER, AUGUST, JULY, JUNE, MAY, APRIL, MARCH, FEBRUARY, JANUARY]
NOVEMBER OCTOBER SEPTEMBER AUGUST JULY JUNE MAY APRIL MARCH FEBRUARY JANUARY stack2 = [NOVEMBER, OCTOBER, SEPTEMBER, AUGUST, JULY, JUNE, MAY, APRIL, MARCH, FEBRUARY, JANUARY]
NOVEMBER OCTOBER SEPTEMBER AUGUST JULY JUNE MAY APRIL MARCH FEBRUARY JANUARY
*///:~