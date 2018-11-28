package lafore.chap04.Infix;// infix.java
// converts infix arithmetic expressions to postfix
// to run this program: C>java InfixApp

import java.io.*;

////////////////////////////////////////////////////////////////
class StackX {
   private int maxSize;
   private char[] stackArray;
   private int top;

   //--------------------------------------------------------------
   public StackX(int s) { // constructor
      maxSize = s;
      stackArray = new char[maxSize];
      top = -1;
   }

   //--------------------------------------------------------------
   public void push(char j) { // put item on top of stack
      stackArray[++top] = j;
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

   //-------------------------------------------------------------
   public int size() { // return size
      return top + 1;
   }

   //--------------------------------------------------------------
   public char peekN(int n) { // return item at index n
      return stackArray[n];
   }

   //--------------------------------------------------------------
   public void displayStack(String string) {
      System.out.print(string);
      System.out.print("Stack (bottom-->top): ");
      for (int i = 0; i < size(); i++) {
         System.out.print(peekN(i));
         System.out.print(' ');
      }
      System.out.println();
   }
//--------------------------------------------------------------
}  // end class StackX

////////////////////////////////////////////////////////////////
class InToPost { // infix to postfix conversion
   private StackX stackX;
   private String input;
   private String output = "";

   //--------------------------------------------------------------
   public InToPost(String in) {                      // constructor
      input = in;
      int stackSize = input.length();
      stackX = new StackX(stackSize);
   }

   //--------------------------------------------------------------
   public String doTranslation() {                   // do translation to postfix
      for (int j = 0; j < input.length(); j++) {      // for each char
         char ch = input.charAt(j);                    // get it
         stackX.displayStack("For " + ch + " "); // *diagnostic*
         switch (ch) {
            case '+':                                   // it's + or -
            case '-':
               gotOperator(ch, 1);                 // go pop operators & (precedence 1)
               break;
            case '*':                                   // it's * or /
            case '/':
               gotOperator(ch, 2);                 // go pop operators & (precedence 2)
               break;
            case '(':                                   // it's a left paren
               stackX.push(ch);                          // push it
               break;
            case ')':                                   // it's a right paren
               gotParen();                               // go pop operators
               break;
            default:                                    // must be an operand
               output = output + ch;                     // write it to output
               break;
         }  // end switch
      }  // end for
      while (!stackX.isEmpty()) {                     // pop remaining operations
         stackX.displayStack("While ");          // *diagnostic*
         output = output + stackX.pop();               // write to output
      }
      stackX.displayStack("End   ");            // *diagnostic*
      return output;                                  // return postfix
   }  // end doTranslation()

   //--------------------------------------------------------------
   public void gotOperator(char opThis, int prec1) { // got operator from input
      while (!stackX.isEmpty()) {
         char opTop = stackX.pop();
         if (opTop == '(') {                           // if it's a '('
            stackX.push(opTop);                         // restore '('
            break;
         } else {                                      // it's an operator & precedence of new op
            int prec2;
            if (opTop == '+' || opTop == '-') {         // search new op prec
               prec2 = 1;
            } else prec2 = 2;
            if (prec2 < prec1) {                        // if prec of new op less & than prec of old
               stackX.push(opTop);                       // save newly-popped op
               break;
            } else output = output + opTop;             // prec of new not less & than prec of old
         }  // end else (it's an operator)
      }  // end while
      stackX.push(opThis);                            // push new operator
   }  // end gotOp()

   //--------------------------------------------------------------
   public void gotParen() {                             // got right parenthesis from input
      while (!stackX.isEmpty()) {
         char chx = stackX.pop();
         if (chx == '(')                 // if popped '('
            break;                        // we're done
         else                            // if popped operator
            output = output + chx;        // output it
      }  // end while
   }  // end popOps()
//--------------------------------------------------------------
} // end class InToPost

////////////////////////////////////////////////////////////////
class InfixApp {
   public static void main(String[] args) throws IOException {
      String input, output;
      while (true) {
         System.out.print("Enter infix: ");
         System.out.flush();
         input = getString();                    // read a string from kbd
         if (input.equals(""))                   // quit if [Enter]
            break;
         // make a translator
         InToPost theTrans = new InToPost(input);
         output = theTrans.doTranslation(); // do the translation
         System.out.println("Postfix is " + output + '\n');
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
}  // end class InfixApp
////////////////////////////////////////////////////////////////
