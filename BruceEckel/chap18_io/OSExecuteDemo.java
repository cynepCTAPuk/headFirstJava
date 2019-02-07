//: io/OSExecuteDemo.java
// Demonstrates standard I/O redirection.
package chap18_io;
import util.*;

import java.util.*;

public class OSExecuteDemo {
    public static void main(String[] args) {
        List list = OSExecute.command("javap OSExecuteDemo", 1);
        System.out.println(list);
    }
} /* Output:
Compiled from "OSExecuteDemo.java"
public class OSExecuteDemo extends java.lang.Object{
public OSExecuteDemo();
public static void main(java.lang.String[]);
}
*///:~