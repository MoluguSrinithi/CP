import java.util.*;
class Encode{
    public static String encoded (int num){
        num = num+1;
        // StringBuilder sb = new StringBuilder();
        // while(num > 1){
        //     sb.append(num & 1);
        //     num = num >> 1;
        // }
        // return sb.reverse().toString();

        String res = Integer.toBinaryString(num);
        return res.substring(1,res.length());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = encoded(n);
        System.out.println(s);
    }
}