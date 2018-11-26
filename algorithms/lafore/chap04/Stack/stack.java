package lafore.chap04.Stack;

// stack.java
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////
class StackX {
  private int maxSize;                  // size of stack array
  private long[] stackArray;
  private int top;                      // top of stack

  //--------------------------------------------------------------
  public StackX(int maxSize) {                // constructor
    this.maxSize = maxSize;                        // set array size
    stackArray = new long[this.maxSize];     // create array
    top = -1;                           // no items yet
  }

  //--------------------------------------------------------------
  public void push(long i) {            // put item on top of stack
    stackArray[++top] = i;              // increment top, insert item
  }

  //--------------------------------------------------------------
  public long pop() {                   // take item from top of stack
    return stackArray[top--];           // access item, decrement top
  }

  //--------------------------------------------------------------
  public long peek() {                  // peek at top of stack
    return stackArray[top];
  }

  //--------------------------------------------------------------
  public boolean isEmpty() {             // true if stack is empty
    return (top == -1);
  }

  //--------------------------------------------------------------
  public boolean isFull() {              // true if stack is full
    return (top == maxSize - 1);
  }
//--------------------------------------------------------------
}  // end class StackX

////////////////////////////////////////////////////////////////
class StackApp {
  public static void main(String[] args) {
    StackX stackX = new StackX(10);  // make new stack
    stackX.push(0);                 // push items onto stack
    stackX.push(1);                 // push items onto stack
    stackX.push(2);
    stackX.push(3);
    stackX.push(4);
    stackX.push(5);
    stackX.push(6);
    stackX.push(7);
    stackX.push(8);
    stackX.push(9);

    while (!stackX.isEmpty()) {         // until it's empty, delete item from stack
      long value = stackX.pop();
      System.out.print(value);            // display it
      System.out.print(" ");
    }  // end while
    System.out.println();
  }  // end main()
}  // end class StackApp
////////////////////////////////////////////////////////////////
