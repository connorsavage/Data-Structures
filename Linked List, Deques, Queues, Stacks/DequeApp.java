/*
*  File name: DequeApp.java
*  Purpose  : Tests deque.java
*  Author  : Erin Hurlburt and Connor Savage
*  Date    : 2021-10-13
*/

class DequeApp {

    public static void main(String[] args) {
        Deque theDeque = new Deque(5);

        theDeque.insertLeftNew(10);
        theDeque.insertLeftNew(20);
        theDeque.insertRightNew(50);
        theDeque.insertRightNew(60);
        theDeque.insertRightNew(70);


        //theDeque.removeRightNew();
        //theDeque.removeLeftNew();


        theDeque.isEmpty();
        theDeque.isFull();

        //theDeque.insert(50);
        //theDeque.insert(60);
        //theDeque.insert(70);
        //theDeque.insert(80);

        //while( !theDeque.isEmpty() ) {
        //    long n = theDeque.remove();
        //    System.out.print(n);
        //    System.out.print(" ");
        //}
        //System.out.println("");

        boolean test = true;
        theDeque.displayDequeArrayContents(test);


    }
}
