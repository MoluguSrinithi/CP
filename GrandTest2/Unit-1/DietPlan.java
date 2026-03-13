import java.util.*;
class DietPlan{
    public static int calories(int[] arr, int k, int l, int u){
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum+=arr[i];
        }
        int points = 0;
        if(sum<l){
            points--;
        }
        else if(sum>u){
            points++;
        }

        for(int i = k; i<arr.length; i++){
            sum+=arr[i]-arr[i-k];
        }
        
        if(sum<l){
            points--;
        }
        else if(sum>u){
            points++;
        }
        return points;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int l = sc.nextInt();
        int u = sc.nextInt();
        System.out.println(calories(arr, k,u,l));
    }
}