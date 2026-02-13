// Given an array nums with n objects colored red, white, or blue, 
// sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function. 

// Example 1:
// input =
// 6
// 2 0 2 1 1 0
// output =0 0 1 1 2 2


// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:

// Input: nums = [2,0,1]
// Output: [0,1,2]
 

// Constraints:

// n == nums.length
// 1 <= n <= 300
// nums[i] is either 0, 1, or 2.

import java.util.*;

class SortColors{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sortedArray(arr);
        for(int ele: arr){
            System.out.print(ele+" ");
        }
    }
    public static void sortedArray(int[] arr){
        int left = 0;
        int right = arr.length-1;
        int curr = 0;
        
        while(curr<=right)
        {
            if(arr[curr] == 0){
                swap(arr,left, curr);
                left++;
                curr++;
            }
            else if(arr[curr] == 1){
                curr++;
            }
            else{
                swap(arr,right,curr);
                right--;
            }
        }
    }
    
    public static void swap(int arr[], int pos, int curr){
        int temp = arr[curr];
        arr[curr] = arr[pos];
        arr[pos] = temp;
    }
}