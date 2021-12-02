/*
*  File name: Deque.java
*  Purpose  : Demonstrates deque
*  Author  : Erin Hurlburt and Connor Savage
*  Date    : 2021-10-13
*/

class Deque {

    private int    maxSize;       // max size at creation
    private long[] dequeArray;    // the underlying storage
    private int    front;         // let's call this "left"
    private int    rearLeft;      // new way of looking at this ~ front is actually right
    private int    rearRight;     // this makes things work more like what we expect
    private int    nItems;

    /**
    *  constructor
    *  @param s int for the size of the underlying array
    */
    public Deque( int s ) {
        maxSize = s;
        dequeArray = new long[maxSize];
        nItems = 0;
        rearLeft =  maxSize - 1;
        rearRight =  0;
    }

    public void insertLeftNew( long j ) {
        if ( nItems == maxSize ) {
            // full message
            rearLeft = nItems;
        } else {
            System.out.println( "     ...inserting " + j + " at [" + rearLeft + "]" );
            rearLeft--;
            dequeArray[rearLeft + 1] = j;
            nItems++;
            // decrement rear and insert
            // one more item
        }
    }

    /**
    *  put item at front of deque
    *  @param j long primitive containing the value to insert
    */
    public void insertRightNew( long j ) {
        if( nItems == maxSize ) {
            // full message
            rearRight = nItems;
        } else {
            System.out.println( "     ...inserting " + j + " at [" + rearRight + "]" );
            rearRight++;
            dequeArray[rearRight - 1] = j;
            nItems++;
            // increment rear and insert
            // one more item
        }
    }

    /**
    *  remove item at front of deque
    *   @return long primitive containing the value removed
    */
    public long removeLeftNew() {
        long temp = 0;
        if( getSize() == 0 ) {
            // empty message
            return 0;
        } else {
            // one less item
            nItems--;
            // save current location in temp
            temp = dequeArray[rearLeft--];
            // set current location to zero to clear it out
            dequeArray[0] = 0;
        }
        return temp;    // return it
    }

    /**
    *  remove item at rear of deque
    *  @return long primitive containing the value removed
    */
    public long removeRightNew() {
        long temp = 0;
        if( getSize() == 0 ) {
            // empty message
            return 0;
        } else {
            // one less item
            nItems--;
            // save current location in temp
            temp = dequeArray[rearRight++];
            // set current location to zero to clear it out
            dequeArray[rearRight] = 0;
        }
        return temp;                              // return it
    }


    /**
    *  peek at front of deque
    *  @return long primitive containing the value peeked at
    */
    public long peekFront() {
        return dequeArray[rearLeft];
    }

    /**
    *  peek at back of deque
    *  @return long primitive containing the value peeked at
    */
    public long peekBack() {
        return dequeArray[rearRight];
    }

    /**
    *  determine if the deque is empty
    *  @return boolean primitive containing true if deque is empty
    */
    public boolean isEmpty() {
        if ( nItems == 0 ) {
            System.out.println("Deque is empty");
            return true;
        }
        return false;
    }

    /**
    *  determine if the deque is full
    *  @return boolean primitive containing true if deque is full
    */
    public boolean isFull() {
        if ( nItems == maxSize ) {
            System.out.println("Deque is full");
            return true;
        }
        return false;
    }

    /**
    *  determine number of items in deque
    *  @return int primitive containing item count
    */
    public int getSize() {
        return nItems;
    }

    /**
    *  display the contents of the deque AS AN ARRAY
    *     note this is NOT NECESSARILY as a "Dequq" view!
    */
    public void displayDequeArrayContents( boolean displayIndices ) {
        if( displayIndices ) {
            System.out.println( "rearLeft : " + rearLeft  + "  rearRight: " + rearRight );
        }
        for( long i : dequeArray ) {
            System.out.print( "[" + i + "]" );
        }
        System.out.println( "" );
    }
}
