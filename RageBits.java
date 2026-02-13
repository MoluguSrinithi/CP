/*
In a digital security system, each device is assigned a unique binary 
access code represented as an integer.The system checks the common security 
bits shared by all devices within a certain ID range.

Given two integers L and R, representing the starting and ending device IDs, 
determine the final security code obtained by performing a bitwise AND operation 
on the access codes of all devices from ID L to ID R (inclusive).

Input Format:
------------
left right

Output Format
----------------
Bitwise AND of all numbers in the range
 

Example 1:
-----------
Input: left = 5, right = 7
Output: 4

Explanation
-------------
The access codes for devices from ID 5 to 7 are:
5 → 101
6 → 110
7 → 111
The common security bits retained after performing
the bitwise AND operation are:

101
110
111
---
100

Hence, the final security code is:
4


Example 2:
-----------
Input: left = 0, right = 0
Output: 0

Example 3:
------------
Input: left = 1, right = 2147483647
Output: 0
 

Constraints:
------------
0 <= left <= right <= 231

Hint:
------
Only the bits that remain unchanged across all IDs in the given range will 
appear in the final result.

*/

import java.util.*;

class RangeBits {
    public static int rangeBits (int left, int right) {
        if (left < 0 || left > 231 || right < 0 || right > 231) return 0;
        int result = 0;
        
        while (left != right) {
            left >>= 1;
            right >>= 1;
            result++;
        }
        
        return left << result;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        System.out.println(rangeBits(left, right));
    }
}