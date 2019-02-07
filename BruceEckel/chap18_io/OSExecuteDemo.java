//: io/OSExecuteDemo.java
// Demonstrates standard I/O redirection.
package chap18_io;
import util.*;

public class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("javap OSExecuteDemo", 1);
    }
} /* Output:
Compiled from "OSExecuteDemo.java"
public class OSExecuteDemo extends java.lang.Object{
public OSExecuteDemo();
public static void main(java.lang.String[]);
}
*///:~