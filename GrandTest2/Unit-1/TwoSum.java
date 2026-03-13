import java.util.*;
class TwoSum{
    public static int[] tSum(int[] arr, int tgt){
        int slow = 0;
        int fast = arr.length-1;
        int sum = 0;
        while(slow<fast){
            sum = arr[slow] + arr[fast];
            if(sum == tgt){
                return new int[]{slow+1, fast+1};
            }
            if(sum > tgt){
                fast--;
            }
            else{
                slow++;
            }

        }
        return new int[]{slow+1, fast+1};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int res[] = tSum(arr,k);
        for(int num: res){
            System.out.print(num+" ");
        }
    }
}