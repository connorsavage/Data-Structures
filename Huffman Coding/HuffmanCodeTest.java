/*
*  File name: HuffmanCodeTest.java
*  Purpose  : Tests HuffmanCode.java
*  Author  : Erin Hurlburt and Connor Savage
*  Date    : 2021-11-9
*/

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.PriorityQueue;
import java.util.Scanner;


class HuffmanCodeTest {

    public static void main(String[] args) {

        HuffmanCode codeTest = new HuffmanCode();

        String testTree1 = "Hello";
        String testTree2 = "This is a test!";
        String testTree3 = "Test 1, 2, 3";

        /*expected: Huffman Codes are: {e=110, h=10, l=0, o=111}
                    The original string is: hello
                    The encoded string is: 1011000111
                    The decoded string is: hello*/
        codeTest.buildHuffmanTree(testTree1);


        /*expected: Huffman Codes are: { =01, a=1010, !=11111, s=00, T=1011, t=110, e=1110, h=11110, i=100}
                    The original string is: This is a test!
                    The encoded string is: 1011111101000001100000110100111011100011011111
                    The decoded string is: This is a test!*/
        codeTest.buildHuffmanTree(testTree2);

        
        /*expected: Huffman Codes are: { =10, 1=1100, 2=0111, 3=001, s=1101, T=010, t=0110, e=000, ,=111}
                    The original string is: Test 1, 2, 3
                    The encoded string is: 0100001101011010110011110011111110001
                    The decoded string is: Test 1, 2, 3*/
        codeTest.buildHuffmanTree(testTree3);                            
    }
}