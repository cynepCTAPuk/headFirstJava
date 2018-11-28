package lafore.chap04.Queue;

// Queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue {
  private int maxSize;
  private long[] queArray;
  private int front;
  private int rear;
  private int nItems;

  //--------------------------------------------------------------
  public Queue(int maxSize) {                                           // constructor
    this.maxSize = maxSize;
    queArray = new long[this.maxSize];
    front = 0;
    rear = -1;
    nItems = 0;
  }

  //--------------------------------------------------------------
  public void insert(long value) {                                // put item at rear of queue
    if (size() == maxSize) {
      System.out.println("-= Queue is full =-");
    } else {
      if (rear == maxSize - 1) rear = -1;                           // deal with wraparound
      System.out.print("front = " + front + " rear = " + rear +
              " items = " + size() + " insert VALUE = " + value);
      queArray[++rear] = value;                                     // increment rear and insert
      nItems++;                                                     // one more item
      System.out.println(" items after = " + size());
    }
  }

  //--------------------------------------------------------------
  public long remove() {                                          // take item from front of queue
    System.out.print("\tfront = " + front + " rear = " + rear +
            " items before = " + size() + " delete VALUE = " + peekFront());
    long temp = queArray[front++];                                // get value and increment front
    if (front == maxSize) front = 0;                              // deal with wraparound
    nItems--;                                                     // one less item
    System.out.println(" items after = " + size());
    return temp;
  }

  //--------------------------------------------------------------
  public long peekFront() {                                       // peek at front of queue
    return queArray[front];
  }

  //--------------------------------------------------------------
  public boolean isEmpty() {                                      // true if queue is empty
    return (nItems == 0);
//    return (rear + 1 == front || (front + maxSize - 1 == rear));
  }

  //--------------------------------------------------------------
  public boolean isFull() {                                       // true if queue is full
    return (nItems == maxSize);
  }

  //--------------------------------------------------------------
  public int size() {                                             // number of items in queue
    return nItems;
/*
    if (rear >= front)                              // Непрерывная последовательность
      return rear - front + 1;
    else                                            // Несвязная последовательность
      return (maxSize - front) + (rear + 1);
*/
  }

//--------------------------------------------------------------
}  // end class Queue

////////////////////////////////////////////////////////////////
class QueueApp {
  public static void main(String[] args) {
    Queue queue = new Queue(5);                      // queue holds 5 items

    queue.insert(10);                             // insert 4 items
    queue.insert(20);
    queue.insert(30);
    queue.insert(40);

    queue.remove();                                     // remove 3 items
    queue.remove();                                     //    (10, 20, 30)
    queue.remove();

    queue.insert(50);                             // insert 4 more items
    queue.insert(60);                             //    (wraps around)
    queue.insert(70);
    queue.insert(80);
    queue.insert(90);

    while (!queue.isEmpty())                            // remove and display
    {                                                   //    all items
      long n = queue.remove();                          // (40, 50, 60, 70, 80)
//      System.out.print(n);
//      System.out.print(" ");

    }
    System.out.println();
  }  // end main()
}  // end class QueueApp
////////////////////////////////////////////////////////////////
