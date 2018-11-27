package lafore.chap04.Brackets;// brackets.java
// stacks used to check matching brackets
// to run this program: C>java bracketsApp

import java.io.*;

////////////////////////////////////////////////////////////////
class StackX {
  private int maxSize;
  private char[] stackArray;
  private int top;

  //--------------------------------------------------------------
  public StackX(int maxSize) { // constructor
    this.maxSize = maxSize;
    stackArray = new char[this.maxSize];
    top = -1;
  }

  //--------------------------------------------------------------
  public void push(char ch) { // put item on top of stack
    if (top < maxSize) stackArray[++top] = ch;
    else System.out.print("Can't insert, stack is full");
  }

  //--------------------------------------------------------------
  public char pop() { // take item from top of stack
    return stackArray[top--];
  }

  //--------------------------------------------------------------
  public char peek() { // peek at top of stack
    return stackArray[top];
  }

  //--------------------------------------------------------------
  public boolean isEmpty() { // true if stack is empty
    return (top == -1);
  }
//--------------------------------------------------------------
}  // end class StackX

////////////////////////////////////////////////////////////////
class BracketChecker {
  private String input;                   // input string

  //--------------------------------------------------------------
  public BracketChecker(String input) { // constructor
    this.input = input;
  }

  //--------------------------------------------------------------
  public void check() {
    int stackSize = input.length();               // get max stack size
    StackX stackX = new StackX(stackSize);      // make stack

    for (int i = 0; i < input.length(); i++) {    // get chars in turn
      char ch = input.charAt(i);                  // get char
      switch (ch) {
        case '{':                                 // opening symbols
        case '[':
        case '(':
          stackX.push(ch);                                // push them
          break;
        case '}':                                           // closing symbols
        case ']':
        case ')':
          if (!stackX.isEmpty()) {                        // if stack not empty,
            char chx = stackX.pop();                      // pop and check
            if ((ch == '}' && chx != '{') ||
                    (ch == ']' && chx != '[') ||
                    (ch == ')' && chx != '('))
              System.out.println("Error-1: " + ch + " at " + i);
          } else {
            System.out.println("Error-2: " + ch + " at " + i); // prematurely empty
          }
          break;
        default:                                             // no action on other characters
          break;
      }  // end switch
    }  // end for
    // at this point, all characters have been processed
    if (!stackX.isEmpty()) System.out.println("Error: missing right delimiter");
  }  // end check()
//--------------------------------------------------------------
}  // end class BracketChecker

////////////////////////////////////////////////////////////////
class BracketsApp {
  public static void main(String[] args) throws IOException {
    String input;
    while (true) {
      System.out.print("Enter string containing delimiters: ");
      System.out.flush();
      input = getString();                                    // read a string from kbd
      if (input.equals("")) break;                            // quit if [Enter]
      BracketChecker bracketChecker = new BracketChecker(input);  // make a BracketChecker
      bracketChecker.check();                                     // check brackets
    }  // end while
  }  // end main()

  //--------------------------------------------------------------
  public static String getString() throws IOException {
    InputStreamReader streamReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(streamReader);
    String line = bufferedReader.readLine();
    return line;
  }
//--------------------------------------------------------------
}  // end class BracketsApp
////////////////////////////////////////////////////////////////
