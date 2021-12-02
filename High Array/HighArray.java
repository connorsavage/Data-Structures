/**
* Filename: HighArray.java
* Description: 
* Author: Erin Hurlburt and Connor Savage
* Date: September 15, 2021
*/

import java.util.Arrays;

public class HighArray {

private long[] a;
private int nElems;

public HighArray(int max) {
    a = new long[max];
    nElems = 0;
}

public boolean find(long searchKey) {
    int j;
    for (j = 0; j < nElems; j++) {
        if (a[j] == searchKey) {
            break;
        }
    }
    if (j == nElems) {
        return false;
    } else {
        return true;
    }
}

public void insert(long value) {
    a[nElems] = value;
        nElems++;
}

public boolean delete(long value) {
int j;
    for (j = 0; j < nElems; j++) {
        if (value == a[j]) {
            break;
        }
    } 
    if (j == nElems) {
        return false;
    } else {
    for (int k = j; k < nElems; k++) {
        a[k] = a[k + 1];
    }
    nElems--;
        return true;
    }
}


public void display() {
    for (int j = 0; j < nElems; j++) {
        System.out.print(a[j] + " ");
    }
    System.out.println(" ");
}



public int getMax() {

// use a (array) and nElemns (number of elements);

long maxNum = a[0];
    if (nElems < 1) {
        System.out.println("-1");
        return -1;
    } else {
        for (int i = 1; i < nElems; i++) {
            if (maxNum < a[i]) {
                maxNum = a[i];
            }
        }
        System.out.println("Max value: " + maxNum);
        int maxInt = (int)maxNum;
        return maxInt;
    }

}

public long[] noDups() {
    for (int i = 0; i < nElems; i++) {
        for (int j = i + 1; j < nElems; j++) {
            if (a[i] == a[j]) {
                int nextElement = j;
                for (int k = j + 1; k < nElems; k++, nextElement++) {
                    a[nextElement] = a[k];
                }
                nElems--;
                j--;
            }
        }
    }

    long[] newArray = new long[nElems];
    System.out.print("No duplicates: ");
    for (int i = 0; i < nElems; i++) {
        newArray[i] = a[i];
        System.out.print(newArray[i] + " ");
    }

    System.out.println(" ");
    return newArray; 

}




}
