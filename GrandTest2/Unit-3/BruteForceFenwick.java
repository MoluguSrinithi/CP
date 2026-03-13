import java.util.*;

class BruteForceFenwick {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        while(Q-- > 0){

            int option = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            // sumRange
            if(option == 1){
                int sum = 0;

                for(int i = a; i <= b; i++){
                    sum += arr[i];
                }

                System.out.println(sum);
            }

            // update
            else if(option == 2){
                arr[a] = b;
            }
        }

        sc.close();
    }
}