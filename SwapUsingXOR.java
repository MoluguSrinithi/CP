/*
Write a Java program to swap two variables without using a third variable.
The program should take two integers as input from the user and swap them using 
the XOR (^) operator.

Examples:
---------
Input-1:
--------
a = 2, b = 3
Output-1: 
---------
a = 3, b = 2

Input-2:
--------
a = 10, b = 10
Output-2:
--------
a = 10, b = 10

*/
import java.util.*;
class SwapUsingXOR{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("a = "+a + ", " + "b = " + b);
    }
}