// Two brothers want to play a game, 
// The rules of the game are: one player gives two sorted lists of 
// numerical elements and a number (sum). 
// The opponent has to find the closest pair of elements 
// to the given sum.
// -> pair consists of elements from each list

// Please help those brothers to develop a program, that takes 
// two sorted lists as input and return a pair as output.

// Input Format:
// -------------
// size of list_1
// list_1 values
// size of list_2
// list_2 values
// closest number

// Output Format:
// --------------
// comma-separated pair

// Sample Input-1:
// ---------------
// 4
// 1 4 5 7
// 4
// 10 20 30 40
// 32
// Sample Output-1
// ---------------
// 1,30

// Sample Input-2
// ---------------
// 3
// 2 4 6
// 4
// 5 7 11 13
// 15

// Sample Output-2
// ---------------
// 2, 13

import java.util.*;

class ClosestPair{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int arr1[] = new int[a];
        for(int i = 0; i<a; i++){
            arr1[i] = sc.nextInt();
        }
        
        int b = sc.nextInt();
        int arr2[] = new int[b];
        for(int i = 0; i<b; i++){
            arr2[i] = sc.nextInt();
        }
        
        int x = sc.nextInt();
        int res[] = closestPair(arr1,arr2,x);
        for(int ele: res){
            System.out.print(ele+" ");
        }
    }
    
    public static int[] closestPair(int arr1[], int arr2[], int x){
        int left = 0;
        int right = arr2.length-1;
        int diff = Integer.MAX_VALUE;
        int res[] = new int[2];
        
        while(left<arr1.length && right>=0){
            int num1 = arr1[left];
            int num2 = arr2[right];
            
            int sum = num1 + num2;
            if(Math.abs(sum-x) < diff){
                diff = Math.abs(sum - x);
                res[0] = arr1[left];
                res[1] = arr2[right];
                
            }
            
            if(sum > x){
                right--;
            }
            else{
                left++;
            }
            
            
        }
        return res;
    }
}