/*
*  File name: OddEvenSortApp.java
*  Purpose  : Tests OddEvenArraySort.java
*  Author  : Erin Hurlburt and Connor Savage
*  Date    : 2021-11-9
*/

class OddEvenSortApp {

    public static void main(String[] args) {
        int maxSize = 100;
        OddEvenArraySort arr = new OddEvenArraySort(maxSize);


        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        System.out.println("Unsorted Array: ");
        arr.display();
        arr.oddEvenSort();

        System.out.println("Odd Even Sorted Array: ");
        arr.display();                            
    }
}
