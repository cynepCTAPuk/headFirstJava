package lafore.chap06.factorial;// factorial.java
// evaluates triangular numbers
// to run this program: C>java FactorialApp

import java.io.*;

////////////////////////////////////////////////////////////////
class FactorialApp {
    static int theNumber;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        int theAnswer = factorial(theNumber);
        System.out.println(String.format("Factorial = %,d", theAnswer));
    }  // end main()

    //-------------------------------------------------------------
    public static int factorial(int n) {
        if (n == 1) {
            System.out.println("Returning = " + n);
            return 1;
        } else {
            int temp = n * factorial(n - 1);
            System.out.println(String.format("Returning %,d! = %,d", n, temp));
            return temp;
//            return (n + factorial(n - 1));
        }
    }

    //-------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        return line;
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String string = getString();
        return Integer.parseInt(string);
    }
//--------------------------------------------------------------
}  // end class FactorialApp
////////////////////////////////////////////////////////////////
