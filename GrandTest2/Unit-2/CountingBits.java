import java.util.*;
class CountingBits {
    public static int[] countBits(int n) {
        int res[] = new int[n+1];
        res[0] = 0;
        for(int i = 1; i<=n;i++){
            // int count = 0;
            // int num = i;
            // while(num > 0){
            //     num = num & (num-1);
            //     count++;
            // }
            // res[i] = count;
            res[i] = res[i/2] + (i%2);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res[] = new int[n+1];
        res = countBits(n);
        for(int num: res){
            System.out.print(num+" ");
        }

    }
}