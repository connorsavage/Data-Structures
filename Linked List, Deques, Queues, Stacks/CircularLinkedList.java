/*
 *  File name: CircularLinkedList.java
 *  Purpose  : demonstrate a circular linked list
 *  @author  : Connor Savage & Erin Hurlburt
 *  @date    : 2021-10-13
 */

public class CircularLinkedList {

    static class Node {
        int data;
        Node next;
        Node() {}
        Node(int data) {
          this.data = data;
        }
    }
     
    private Node current;
    private Node tail;
     
    // constructor  
    public CircularLinkedList() {
        this.current = null;
        this.tail = null;
    }
     
    public boolean isEmpty() {
        return current == null;
    }
     
    
    public void insertion(int num) {
        //Create new node  
        Node newNode = new Node(num);
        //Checks if the list is empty.  
        if (current == null) {
            //If list is empty, both current and tail would point to new node.  
            current = newNode;
            tail = newNode;
            newNode.next = current;
        } else {
            //tail will point to new node.  
            tail.next = newNode;
            //New node will become new tail.  
            tail = newNode;
            //Since, it is circular linked list tail will point to current.  
            tail.next = current;
        }
    }
     
    /**
    *
    * @param data
    * @param position
    */
    public void insertAtIndex(int data, int position) {
        Node temp, newNode;
        int i, count;
        newNode = new Node();
        temp = current;
        count = size();
        if (temp == null || size() < position) {
            System.out.println("Index is greater than size of the list");
        } else {
            newNode.data = data;
            for (i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
     
    
    public void deletion(int num) {
        if (current == null) {
            System.out.println("List is empty");
        }
            // Find the required node  
        Node currentNode = current;
        Node previousNode = new Node();
        while (currentNode.data != num) {
            if (currentNode.next == current) {
                System.out.println("Given node with data " + num + " is not found in the circular linked list.");
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        
     
            // Check if node is only node  
        if (currentNode == current && currentNode.next == current) {
            current = null;
        }
     
            // If more than one node, check if  
            // it is first node  
        if (currentNode == current) {
            previousNode = current;
            while (previousNode.next != current) {
                previousNode = previousNode.next;
            }
            current = currentNode.next;
            previousNode.next = current;
            
     
        // check if node is last node  
        } else if (currentNode.next == current) {
            previousNode.next = current;
        } else {
            previousNode.next = currentNode.next;
        }
        
    }

     
        /**
        * Display forward
        */
    public void display() {
        Node temp = current;
        if (current != null) {
            do {
                System.out.printf("%d ", temp.data);
                temp = temp.next;
            } while (temp != current);
        }
        System.out.printf("\n");
    }
     
    public int size() {
        int size = 0;
        if (current != null) {
            Node temp = current;
            while (temp.next != current) {
                temp = temp.next;
                size++;
            }
            size++;
        }
        return size;
    }
     
    
    public void searching(int num) {
        //Node current will point to current  
        Node node1 = current;
        int i = 1;
        boolean flag = false;
        //Checks whether list is empty  
        if (current == null) {
            System.out.println("List is empty");
        } else {
            do {
                //Compares element to be found with each node present in the list  
                if (node1.data == num) {
                    flag = true;
                    break;
                }
            node1 = node1.next;
            i++;
            } while (node1 != current);
            if (flag) {
                System.out.println(num + " was found at index " + i);
            } else {
                System.out.println(num + " was not found in the list");
            }
        }
    }


    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertion(8);
        list.display();
        System.out.println("size :" + list.size());
        list.insertAtIndex(1, 0);
        list.display();
        System.out.println("size :" + list.size());
        list.insertAtIndex(2, 1);
        list.display();
        System.out.println("size :" + list.size());
        list.insertAtIndex(3, 2);
        list.display();
        System.out.println("size :" + list.size());
        list.insertAtIndex(4, 3);
        list.display();
        System.out.println("size :" + list.size());
        list.insertAtIndex(5, 4);
        list.display();
        System.out.println("size :" + list.size());

     
        list.deletion(2);
        System.out.println("Node 2 has been deleted");
        list.display();
        System.out.println("size :" + list.size());

     
        list.searching(8);
        list.display();


        list.searching(3);
        list.display();
    }

}
