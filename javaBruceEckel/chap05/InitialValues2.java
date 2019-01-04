package chap05;

//: initialization/InitialValues.java
// Shows default initial values.

import static util.Print.*;

public class InitialValues2 {
    boolean bool = true;
    char ch = 'x';
    byte b = 47;
    short s = 0xff;
    int i = 999;
    long lng = 1;
    float f = 3.14f;
    double d = 3.14159;
    InitialValues2 reference;

    void printInitialValues() {
        print("Data type Initial value");
        print("boolean " + bool);
        print("char [" + ch + "]");
        print("byte " + b);
        print("short " + s);
        print("int " + i);
        print("long " + (lng + 1));
        print("float " + f);
        print("double " + d);
        print("reference " + reference);
    }

    public static void main(String[] args) {
        InitialValues2 iv = new InitialValues2();
        iv.printInitialValues();
        /* You could also say: new InitialValues().printInitialValues();*/
    }
} /* Output:
Data type Initial value
boolean false
char [ ]
byte 0
short 0
int 0
long 0
float 0.0
double 0.0
reference null
*///:~