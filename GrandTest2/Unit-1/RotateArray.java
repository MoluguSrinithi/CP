import java.util.*;
class RotateArray{
    public static void rotate(int[] arr, int n, int k){
        k = k%n;
        helper(arr,0,n);
        helper(arr,0,k);
        helper(arr,k, n);
    }

    public static void helper(int arr[], int start, int end){
        int l = start;
        int r = end-1;
        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        rotate(arr,n,k);
        for(int num: arr){
            System.out.print(num+" ");
        }
    }
}