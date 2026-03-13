/*
Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input-1:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

Sample Output-1:
----------------
75
86
80



Sample Input-2:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 0 7

Sample Output-2:
----------------
75
86
83

*/

import java.util.*;

class FenwickTree {

    int[] BIT; 
    int[] arr; 
    int n;
    FenwickTree(int[] arr) {
        this.arr = arr;
        this.n = arr.length;

        BIT = new int[n + 1]; 
        for (int i = 0; i < n; i++) {
            updateInternal(i + 1, arr[i]);
        }
    }

    void updateInternal(int i, int delta) {
        while (i <= n) {
            BIT[i] += delta;
            i += (i & -i);
        }
    }

    void update(int index, int newValue) {
        int diff = newValue - arr[index];
        arr[index] = newValue;
        updateInternal(index + 1, diff);
    }
    int getSum(int index) {
        int sum = 0;
        index = index + 1;

        while (index > 0) {
            sum += BIT[index];
            index -= (index & -index);
        }

        return sum;
    }

    int sumRange(int left, int right) {
        if (left == 0)
            return getSum(right);
        return getSum(right) - getSum(left - 1);
    }
}

class FenWickTree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        FenwickTree ft = new FenwickTree(arr);

        while (Q-- > 0) {

            int option = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (option == 1) {

                System.out.println(ft.sumRange(a, b));
            }
            else if (option == 2) {

                ft.update(a, b);
            }
        }

        sc.close();
    }
}