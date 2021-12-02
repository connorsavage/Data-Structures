/*
*  File name: OddEvenArraySort.java
*  Purpose  : Sorts with the Odd Even technique 
*  Author  : Erin Hurlburt and Connor Savage
*  Date    : 2021-11-9
*/

class OddEvenArraySort {

    private int[] a;
    private int nElems;


    public OddEvenArraySort(int max) {
        a = new int[max];
        nElems = 0;
    }


    public void insert(int value) {
        a[nElems] = value;
        nElems++;
    }


    public void display() {
        for (int j = 0; j < nElems; j++) {
        System.out.print(a[j] + " ");
        }

    System.out.println("");
    }


    public void oddEvenSort() {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            int temp = 0;
  
            for (int i = 1; i <= nElems - 2; i += 2) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    isSorted = false;
                }
            }
  
            for (int i = 0; i <= nElems - 2; i += 2) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
        return;
    }


    private void swap(int one, int two) {
        int temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}


