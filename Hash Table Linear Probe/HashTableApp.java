/*
*  File name : HashTableApp.java
*  Purpose : Implements Strings in a linearly probing hash table
*  Author : Connor Savage
*  Date : 2021-12-7
*/

import java.io.*;

class DataItem { // (could have more data)

    private String sData; // data item (key)

    public DataItem(String ii) {// constructor
        sData = ii; }
    public String getKey() {
        return sData; }
}


class HashTable {

    private DataItem[] hashArray; // array holds hash table
    private int arraySize;
    private DataItem nonItem; // for deleted items

    public HashTable(int size) { // constructor
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem("-1"); // deleted item key is -1
    }


    public void displayTable() {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++) {
            if(hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }


    public int hashFunc(String key) {
        int hashVal = 0;
        int pow27 = 1; // 1, 27, 27*27, etc
        //System.out.println("key is " + key);
        for(int j=key.length()-1; j>=0; j--) { // right to left
            int letter = key.charAt(j) - 48; // get char code
            hashVal += pow27 * letter; // times power of 27
            pow27 *= 27; // next power of 27
        }
        //System.out.println("hashval is " + hashVal);
        //System.out.println("hashVal % arraySize " + hashVal % arraySize);
        return hashVal % arraySize;
    }


    public void insert(DataItem item) {// insert a DataItem
        // (assumes table not full)
        String key = item.getKey(); // extract key
        int hashVal = hashFunc(key); // hash the key
        // until empty cell or -1,
        while(hashArray[hashVal] != null && !hashArray[hashVal].getKey().equals("-1")) {
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }
        hashArray[hashVal] = item; // insert item
    } // end insert(


    public DataItem delete(String key) { // delete a DataItem
        int hashVal = hashFunc(key); // hash the key
        while(hashArray[hashVal] != null) {// until empty cell,
            // found the key?
            if(hashArray[hashVal].getKey().equals(key)) {
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem; // delete item
                return temp; // return item
            }
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }
        return null; // can’t find item
    } // end delete()


    public DataItem find(String key) {// find item with key
        int hashVal = hashFunc(key); // hash the key
        while(hashArray[hashVal] != null) { // until empty cell,
            // found the key?
            if(hashArray[hashVal].getKey().equals(key))
                return hashArray[hashVal]; // yes, return item
                ++hashVal; // go to next cell
                hashVal %= arraySize; // wraparound if necessary
        }
        return null; // can’t find item
    }

} // end class HashTable


class HashTableApp {
    
    public static void main(String[] args) throws IOException {
        DataItem aDataItem;
        int size, n, keysPerCell;
        String aKey;

        // get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;
        // make table
        HashTable theHashTable = new HashTable(size);
        for(int j=0; j<n; j++) { // insert data
            aKey = Integer.valueOf((int)Math.random() *
            keysPerCell * size).toString();
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);
        }
        while(true) { // interact with user
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
        switch(choice) {
            case 's':
            theHashTable.displayTable();
            break;
            case 'i':
            System.out.print("Enter a word to insert: ");
            aKey = getString();
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);
            break;
            case 'd':
            System.out.print("Enter a word to delete: ");
            aKey = getString();
            theHashTable.delete(aKey);
            break;
            case 'f':
            System.out.print("Enter a word to find: ");
            aKey = getString();

            aDataItem = theHashTable.find(aKey);
            if(aDataItem != null) {
                System.out.println("Found " + aKey);
            } else
                System.out.println("Could not find " + aKey);
            break;
            default:
            System.out.print("Invalid entry\n ");
        } // end switch
        } // end while
    } // end main()


    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }


    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }


    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
} // end class HashTableApp
