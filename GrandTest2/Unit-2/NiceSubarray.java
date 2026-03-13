import java.util.*;
class NiceSubarray{
    public static int longestArray(int[] nums){
        int left = 0;
        int mask = 0;
        int ans = 0;
        for(int right = 0; right< nums.length; right++){
            if((nums[right] & mask) !=0){
                mask ^= nums[left];
                left++;
            }
            mask|=nums[right];
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(longestArray(arr));
    }
}