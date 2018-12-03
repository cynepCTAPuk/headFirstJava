package lafore.chap06.triangle;// factorial.java
// evaluates triangular numbers
// to run this program: C>java TriangleApp

import java.io.*;

////////////////////////////////////////////////////////////////
class TriangleApp {
    static int theNumber;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        int theAnswer = triangle(theNumber);
        System.out.println("Triangle = " + theAnswer);
    }  // end main()

    //-------------------------------------------------------------
    public static int triangle(int n) {
        if (n < 1) {
            System.out.println("Number must be more than 1");
            return -1;
        } else {
            if (n == 1) {
                System.out.println("Returning 1");
                return 1;
            } else {
                int temp = n + triangle(n - 1);
                System.out.println("Returning " + temp);
                return temp;
            }
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
}  // end class TriangleApp
////////////////////////////////////////////////////////////////
