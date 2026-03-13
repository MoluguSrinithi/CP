import  java.util.*;
class MaximumOfSubarray{
    public static void printMax(int arr[], int n,int k){
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i<k; i++){
            while(!q.isEmpty() && arr[q.peekLast()] < arr[i]){
                q.removeLast();
            }
            q.addLast(i);
        }

        for(int i = k; i<n; i++){
            System.out.print(arr[q.peek()]+" ");

            while(!q.isEmpty() && q.peek() <=i-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && arr[q.peekLast()] < arr[i]){
                q.removeLast();
            }
            q.addLast(i);
            
        }
        System.out.print(arr[q.peek()]+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        printMax(arr, n, k);   
    }
}