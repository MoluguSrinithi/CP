import java.util.*;
class upperCase{
    public static void main(String[] args) {
        String str = "cHerry";
        System.out.println(togglecase(str.toCharArray()));

    }

    public static String togglecase(char[] a){
        for(int i = 0; i<a.length; i++){
            a[i]^=32;
        }
        return new String(a);
    }
}