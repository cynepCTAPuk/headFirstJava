package lafore.chap04.Reverse;// reverse.java
// stack used to reverse a string
// to run this program: C>java ReverseApp

import java.io.*;

////////////////////////////////////////////////////////////////
class StackX {
  private int maxSize;
  private char[] stackArray;
  private int top;

  //--------------------------------------------------------------
  public StackX(int maxSize) {                   // constructor
    this.maxSize = maxSize;
    stackArray = new char[this.maxSize];
    top = -1;
  }

  //--------------------------------------------------------------
  public void push(char ch) {                    // put item on top of stack
    stackArray[++top] = ch;
  }

  //--------------------------------------------------------------
  public char pop() {                            // take item from top of stack
    return stackArray[top--];
  }

  //--------------------------------------------------------------
  public char peek() {                           // peek at top of stack
    return stackArray[top];
  }

  //--------------------------------------------------------------
  public boolean isEmpty() {                    // true if stack is empty
    return (top == -1);
  }
//--------------------------------------------------------------
}  // end class StackX

////////////////////////////////////////////////////////////////
class Reverser {
  private String input;                         // input string
  private String output;                        // output string

  //--------------------------------------------------------------
  public Reverser(String input) {               // constructor
    this.input = input;
  }

  //--------------------------------------------------------------
  public String doRev() {                       // reverse the string
    int stackSize = input.length();             // get max stack size
    StackX stackX = new StackX(stackSize);      // make stack

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);                // get a char from input
      stackX.push(ch);                          // push it
    }
    output = "";
    while (!stackX.isEmpty()) {
      char ch = stackX.pop();                   // pop a char,
      output = output + ch;                     // append to output
    }
    return output;
  }  // end doRev()
//--------------------------------------------------------------
}  // end class Reverser

////////////////////////////////////////////////////////////////
class ReverseApp {
  public static void main(String[] args) throws IOException {
    String input, output;
    while (true) {
      System.out.print("Enter a string: ");
      System.out.flush();
      input = getString();                      // read a string from kbd
      if (input.equals("")) break;              // quit if [Enter]

      Reverser reverser = new Reverser(input);  // make a Reverser
      output = reverser.doRev();                // use it
      System.out.println("Reversed: " + output);
    }  // end while
  }  // end main()

  //--------------------------------------------------------------
  public static String getString() throws IOException {
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String line = bufferedReader.readLine();
    return line;
  }
//--------------------------------------------------------------
}  // end class ReverseApp
////////////////////////////////////////////////////////////////
