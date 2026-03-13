import java.util.*;
class FirstSetBit{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(helper(n));
    }

    public static int helper(int n){
        // return n&(-n);

        if(n == 0){
            return 0;
        }
        int k = 1;
        while(true){
            if((n&(1<<(k-1))) == 0){
                k++;
            }
            else{
                return k;
            }
        }
    }
}