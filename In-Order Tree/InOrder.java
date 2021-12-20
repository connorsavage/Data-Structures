/*
*  File name : InOrder.java
*  Purpose : Does an in-order traversal on a tree
*  Author : Connor Savage and Erin Hurlburt
*  Date : 2021-12-7
*/

public class InOrder {

    public static void inOrderPrinter( TreeNodes node ) {
        if( node == null ) {
            return;
        }
        inOrderPrinter( node.getChild( "L" ) );
        System.out.print( "[" + node.data + "]" );
        inOrderPrinter( node.getChild( "R" ) );
    }


    public static void main( String[] args ) {
         TreeNodes root = new TreeNodes( 0 );
         root.add( 1, "L" );
         root.add( 2, "R" );
         TreeNodes one = root.getChild( "L" );
         TreeNodes two = root.getChild( "R" );
         one.add( 3, "L" );
         one.add( 4, "R" );
         two.add( 5, "L" );
         two.add( 6, "R" );
         TreeNodes six = two.getChild( "R" );
         six.add( 7, "L" );
         six.add( 8, "R" );


        System.out.print("This is the in-order: ");
        inOrderPrinter(root);
      }
   }