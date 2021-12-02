/*
 *  File name: Queue.java
 *  Purpose  : Demonstrates queue
 *  @author  : Connor Savage & Erin Hurlburt
 *  @date    : 2021-10-13
 */

class Queue {

   private int    maxSize;
   private long[] queueArray;
   private int    front;
   private int    rear;
   private int    nItems;


   public Queue(int s) {
      maxSize = s;
      queueArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
   }

   public void insert(long j) {
      if(rear == maxSize - 1) {
         rear = -1;
      }
      queueArray[++rear] = j;
      nItems++;
   }

   public long remove() {
      long temp = queueArray[front++];
      if(front == maxSize) {
         front = 0;
      }
      nItems--;
      return temp;
   }

   public long peekFront() {
      return queueArray[front];
   }

   public boolean isEmpty() {
      return (nItems == 0);
   }

   public boolean isFull() {
      return (nItems == maxSize);
   }

   public int size() {
      return nItems;
   }

   public void displayQueueArrayContents( boolean display ) {
      int startFront = front;
      for (int j = front ;j <nItems; j++ ) {  
         System.out.print("[" + queueArray[j] + "] ");
         if (j == nItems-1 ) {
            j=0;
            System.out.print("[" + queueArray[j] + "]" + " ");
         }
         if (j==startFront-1)
            return;
      }
   }
}
      /*if( displayIndices ) {
         System.out.println( " front: " + front  + "  rear: " + rear );
      }
      for( long i : queueArray ) {
         System.out.print( "[" + i + "]" );
      }
         System.out.println( "" );
   }*/