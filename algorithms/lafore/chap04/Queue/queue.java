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
         System.out.println("***** Queue is full and \"" + value + "\" hadn't be inserted into queue *****");
      } else {
         if (rear == maxSize - 1) rear = -1;                           // deal with wraparound
         System.out.print("front = " + front + " rear = " + rear +
                 " size before = " + size() + " insert VALUE = \"" + value + "\"");
         queArray[++rear] = value;                                     // increment rear and insert
         nItems++;                                                     // one more item
         System.out.println(" size after = " + size());
      }
   }

   //--------------------------------------------------------------
   public long remove() {                                          // take item from front of queue
      System.out.print("\tfront = " + front + " rear = " + rear +
              " size before = " + size() + " delete VALUE = \'" + peekFront() + "\"");
      long temp = queArray[front++];                                // get value and increment front
      if (front == maxSize) front = 0;                              // deal with wraparound
      nItems--;                                                     // one less item
      System.out.println(" size after = " + size());
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
   public void display() {
      System.out.print("***** Queue [");
      for (int i = 0; i < size(); i++) {
         if ((front + i) < maxSize) System.out.print(queArray[(front + i)] + " ");
         if ((front + i) >= maxSize) System.out.print( queArray[((front + i) - maxSize)] + " ");
      }
      System.out.println("] *****");
   }

//--------------------------------------------------------------
}  // end class Queue

////////////////////////////////////////////////////////////////
class QueueApp {
   public static void main(String[] args) {
      Queue queue = new Queue(5);                      // queue holds 5 items

      queue.insert(10);
      queue.insert(20);
      queue.insert(30);
      queue.insert(40);
      queue.insert(50);
      queue.insert(60);

      queue.remove();
      queue.remove();
      queue.remove();
      queue.remove();

      queue.insert(70);
      queue.insert(80);
      queue.insert(90);

      queue.display();

      while (!queue.isEmpty()) {                           // remove and display all items
         long n = queue.remove();                          // (40, 50, 60, 70, 80)
      }
   }  // end main()
}  // end class QueueApp
////////////////////////////////////////////////////////////////
