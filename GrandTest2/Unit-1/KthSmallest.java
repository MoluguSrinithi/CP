import java.util.*;
class KthSmallest{
    public static int smallest(int[] arr, int k){
        int left = Integer.MAX_VALUE;
        int right = 0;
        for(int num : arr){
            left = Math.min(left,num);
            right+=num;
        }

        while(left<right){
            int mid = left + (right-left)/2;
            if(countSubarrays(arr, mid) >= k){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    public static int countSubarrays(int arr[], int s){
        int left = 0;
        int sum = 0;
        int count = 0;
        for(int right = 0; right < arr.length; right++){
            sum+=arr[right];
            while(sum > s){
                sum-=arr[left];
                left++;
            }
            count+= right-left+1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(smallest(arr,k));   
    }
}