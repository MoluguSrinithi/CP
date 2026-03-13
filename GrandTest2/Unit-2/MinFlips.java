import java.util.*;
class MinFlips{
    public static int minFlipCount(int a, int b){
        int xor = a^b;
        int count = 0;
        while(xor>0){
            xor&=(xor-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter start: ");
        int a = sc.nextInt();
        System.out.printf("Enter end: ");
        int b = sc.nextInt();
        System.out.println(minFlipCount(a, b));
    }
}