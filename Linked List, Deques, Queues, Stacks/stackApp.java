/*
*  File name: CircularStack.java
*  Purpose  : Demonstrates a stack
*  Author  : Erin Hurlburt and Connor Savage
*  Date    : 2021-10-13
*/

class StackApp {

    public static void main( String[] args ) {
        CircularStack testStack = new CircularStack();
        testStack.push( 19 );
        testStack.push( 23 );
        testStack.push( 29 );
        testStack.push( 55 );

        testStack.pop();

        testStack.push( 68 );
        testStack.push( 70 );


        testStack.display();

        testStack.pop();
        testStack.display();


        System.out.println( "The top of the stack: " + testStack.peek() );

        testStack.push(88);
        testStack.display();

        System.out.println( "The top of the stack: " + testStack.peek() );  
    }
}