/*
*  File name : TreeNodes.java
*  Purpose : Creates tree nodes for InOrder.java to run methods on
*  Author : Connor Savage and Erin Hurlburt
*  Date : 2021-12-7
*/

public class TreeNodes {

      public int data;
      private TreeNodes left;
      private TreeNodes right;

      TreeNodes ( int d ) {
          data = d;
          left = null;
          right = null;
      }

      public void add( int s, String child ) {
         child = child.toUpperCase();
         if( child.equals( "L" ) ) {
            left = new TreeNodes( s );
         } else if( child.equals( "R" ) ) {
            right = new TreeNodes( s );
         } else {
            throw new IllegalArgumentException();
         }
      }

      public TreeNodes getChild( String child ) {
         child = child.toUpperCase();
         if( child.equals("L") || child.equals("R") ) {
            return (child.equals("L") ? left : right);
         } else {}
            throw new IllegalArgumentException();
         }

      public int getString() {
          return data;
      }
   }