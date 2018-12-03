package lafore.chap06.stackTriangle;
// stackTriangle.java
// evaluates triangular numbers, stack replaces recursion
// to run this program: C>java StackTriangleApp

import java.io.*;

////////////////////////////////////////////////////////////////
class Params {      // parameters to save on stack
    public int n;
    public int returnAddress;

    public Params(int nn, int ra) { // constructor
        n = nn;
        returnAddress = ra;
    }
}  // end class Params

////////////////////////////////////////////////////////////////
class StackX {
    private int maxSize;         // size of StackX array
    private Params[] stackArray;
    private int top;             // top of stack

    //--------------------------------------------------------------
    public StackX(int s) {  // constructor
        maxSize = s;              // set array size
        stackArray = new Params[maxSize];  // create array
        top = -1;                 // no items yet
    }

    //--------------------------------------------------------------
    public void push(Params p) {      // put item on top of stack
        stackArray[++top] = p;    // increment top, insert item
    }

    //--------------------------------------------------------------
    public Params pop() {      // take item from top of stack
        return stackArray[top--]; // access item, decrement top
    }

    //--------------------------------------------------------------
    public Params peek() {  // peek at top of stack
        return stackArray[top];
    }
//--------------------------------------------------------------
}  // end class StackX

////////////////////////////////////////////////////////////////
class StackTriangleApp {
    static int theNumber;
    static int theAnswer;
    static StackX theStack;
    static int codePart;
    static Params theseParams;

    //-------------------------------------------------------------
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        recTriangle();
        System.out.println("Triangle=" + theAnswer);
    }  // end main()

    //-------------------------------------------------------------
    public static void recTriangle() {
        theStack = new StackX(10000);
        codePart = 1;
        while (step() == false)  // call step() until it's true
            if (theAnswer <= 9) {
                System.out.print("case " + codePart + ". theAnswer = " + theAnswer + " ");
            } else {
                System.out.print("case " + codePart + ". theAnswer = " + theAnswer);
            }
        ;                     // null statement
    }

    //-------------------------------------------------------------
    public static boolean step() {

        switch (codePart) {
            case 1:                              // initial call
                System.out.print("case " + codePart + ". theAnswer = " + theAnswer + " ");
                System.out.print(" Stack:");
                theseParams = new Params(theNumber, 6);
                theStack.push(theseParams);
                codePart = 2;
                System.out.println();
                break;
            case 2:                              // method entry
                System.out.print(" Stack: (" + theStack.peek().n + ", " + theStack.peek().returnAddress + ")");
                theseParams = theStack.peek();
                if (theseParams.n == 1) {        // test
                    theAnswer = 1;
                    codePart = 5;   // exit
                } else {
                    codePart = 3;   // recursive call
                }
                System.out.println();
                break;
            case 3:                              // method call
                System.out.print(" Stack: (" + theStack.peek().n + ", " + theStack.peek().returnAddress + ")");
                Params newParams = new Params(theseParams.n - 1, 4);
                theStack.push(newParams);
                System.out.print(" Stack: (" + theStack.peek().n + ", " + theStack.peek().returnAddress + ")");
                codePart = 2;  // go enter method
                System.out.println();
                break;
            case 4:                              // calculation
                System.out.print(" Stack: (" + theStack.peek().n + ", " + theStack.peek().returnAddress + ")");
                theseParams = theStack.peek();
                theAnswer = theAnswer + theseParams.n;
                System.out.print(" Stack: (" + theStack.peek().n + ", " + theStack.peek().returnAddress + ")");
                codePart = 5;
                System.out.println();
                break;
            case 5:                              // method exit
                System.out.print(" Stack: (" + theStack.peek().n + ", " + theStack.peek().returnAddress + ")");
                theseParams = theStack.peek();
                codePart = theseParams.returnAddress; // (4 or 6)
                theStack.pop();
                System.out.println();
                break;
            case 6:                              // return point
                System.out.println(" Stack:");
                return true;
        }  // end switch
        return false;
    }  // end factorial

    //-------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String readLine = br.readLine();
        return readLine;
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String string = getString();
        return Integer.parseInt(string);
    }
//--------------------------------------------------------------
}  // end class StackTriangleApp
////////////////////////////////////////////////////////////////
