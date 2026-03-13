import java.util.*;
class MinFlipsThree{
    public static int helper(int a, int b, int c){
        int ans = 0;
        for(int i = 0; i<32; i++){
            int bitc = (c>>i)&1;
            int bitb = (b>>i)&1;
            int bita = (a>>i)&1;

            if((bita | bitb) !=bitc){
                ans+=(bitc == 0)?(bita == 1 && bitb ==1)?2:1:1;
            }
            
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 6;
        int c = 5;
        System.out.println(helper(a,b,c));
    }
}