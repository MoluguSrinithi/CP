import java.util.*;
class PalindromePermutation{

    static boolean isValidPermu(String s){
        int bitmask = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            bitmask = bitmask ^ (1<<(ch - 'a'));
        }
        return (bitmask == 0 || (bitmask & (bitmask-1)) == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isValidPermu(s));
    }
}