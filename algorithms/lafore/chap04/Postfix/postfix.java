package lafore.chap04.Postfix;// postfix.java
// parses postfix arithmetic expressions
// to run this program: C>java PostfixApp

import java.io.*;

////////////////////////////////////////////////////////////////
class StackX {
   private int maxSize;
   private int[] stackArray;
   private int top;

   //--------------------------------------------------------------
   public StackX(int size) {  // constructor
      maxSize = size;
      stackArray = new int[maxSize];
      top = -1;
   }

   //--------------------------------------------------------------
   public void push(int j) { // put item on top of stack
      stackArray[++top] = j;
   }

   //--------------------------------------------------------------
   public int pop() { // take item from top of stack
      return stackArray[top--];
   }

   //--------------------------------------------------------------
   public int peek() { // peek at top of stack
      return stackArray[top];
   }

   //--------------------------------------------------------------
   public boolean isEmpty() { // true if stack is empty
      return (top == -1);
   }

   //--------------------------------------------------------------
   public boolean isFull() { // true if stack is full
      return (top == maxSize - 1);
   }

   //--------------------------------------------------------------
   public int size() { // return size
      return top + 1;
   }

   //--------------------------------------------------------------
   public int peekN(int n) { // return size
      return stackArray[n];
   }

   //--------------------------------------------------------------
   public void displayStack(String s) {
      System.out.print(s);
      System.out.print("Stack (bottom-->top): ");
      for (int j = 0; j < size(); j++) {
         System.out.print(peekN(j));
         System.out.print(' ');
      }
      System.out.println();
   }
//--------------------------------------------------------------
}  // end class StackX

////////////////////////////////////////////////////////////////
class ParsePost {
   private StackX stackX;
   private String input;

   //--------------------------------------------------------------
   public ParsePost(String in) {
      input = in;
   }

   //--------------------------------------------------------------
   public int doParse() {
      stackX = new StackX(20);               // make new stack
      char ch;
      int i, num1, num2, interAns;

      for (i = 0; i < input.length(); i++) {          // for each char,
         ch = input.charAt(i);                        // read from input
         stackX.displayStack("" + ch + " ");       // *diagnostic*
         if (ch >= '0' && ch <= '9') {                // if it's a number
            stackX.push((int) (ch - '0'));            // push it
         } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') { // it's an operator
            num2 = stackX.pop();                      // pop operands
            num1 = stackX.pop();
            switch (ch)                               // do arithmetic
            {
               case '+':
                  interAns = num1 + num2;
                  break;
               case '-':
                  interAns = num1 - num2;
                  break;
               case '*':
                  interAns = num1 * num2;
                  break;
               case '/':
                  interAns = num1 / num2;
                  break;
               default:
                  interAns = 0;
            }  // end switch
            stackX.push(interAns);                    // push result
         } else {
            System.out.println("It musb be only digits and +-*/");
            return -1;
         } // end else
      }  // end for
      interAns = stackX.pop();                      // get answer
      return interAns;
   }  // end doParse()
}  // end class ParsePost

////////////////////////////////////////////////////////////////
class PostfixApp {
   public static void main(String[] args) throws IOException {
      String input;
      int output;

      while (true) {
         System.out.print("Enter postfix: ");
         System.out.flush();
         input = getString();                            // read a string from kbd
         if (input.equals("")) break;                    // quit if [Enter]

         ParsePost aParser = new ParsePost(input);       // make a parser
         output = aParser.doParse();                     // do the evaluation
         System.out.println("Evaluates to " + output);
      }  // end while
   }  // end main()

   //--------------------------------------------------------------
   public static String getString() throws IOException {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String line = br.readLine();
      return line;
   }
//--------------------------------------------------------------
}  // end class PostfixApp
////////////////////////////////////////////////////////////////
