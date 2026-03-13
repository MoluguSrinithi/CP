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

    public static int[] closestPair(int[] arr1, int[] arr2, int tgt){
        int left = 0;
        int right = arr2.length-1;
        int sum = 0;
        int res[] = new int[2];
        int diff = Integer.MAX_VALUE;

        while(left< arr1.length && right > 0){
            sum = arr1[left]+ arr2[right];

            if(Math.abs(sum-tgt) < diff){
                diff = Math.abs(sum-tgt);
                res[0] = arr1[left];
                res[1] = arr2[right];
            }
            if(sum > tgt){
                right--;
            }
            else{
                left++;
            }
        }
        return res;
    }
}