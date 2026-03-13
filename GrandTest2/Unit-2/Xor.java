import java.util.*;
class Xor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // System.out.println("Before Swapping: "+ "a: "+a+" b: "+b);
        // a = a^b;
        // b= b^a;
        // a = a^b;
        // System.out.println("After Swapping: "+ "a: "+a+" b: "+b);


        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        // System.out.println(findSingleNonRepeated(arr));
        findTwoNonRepeated(arr);
    }

    public static int findSingleNonRepeated(int[] arr){
        int xor = 0;
        for(int num : arr){
            xor^=num;
        }
        return xor;
    }
    public static void findTwoNonRepeated(int[] arr){
        int xor = 0;
        for(int num : arr){
            xor^=num;
        }
        int rightmost = xor&(-xor);
        int num1 = 0;
        int num2 = 0;
        for(int num: arr){
            if((num&rightmost) == 0){
                num1^=num;
            }
            else{
                num2^=num;
            }
        }
        System.out.println(num1+ " "+ num2);
    }
}