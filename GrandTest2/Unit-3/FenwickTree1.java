import java.util.*;
class FenWickTree{
    int []BIT;
    int [] arr;
    int n;

    FenWickTree(int [] arr){
        this.arr = arr;
        this.n = arr.length;
        BIT = new int[n+1];

        for(int i = 0; i<n;i++){
            updateInternal(i+1, arr[i]);
        }
    }

    public void updateInternal(int i, int value){
        while(i<=n){
            BIT[i]+= value;
            i+= (i & -i);
        }
    }

    void update(int index, int newValue){
        int diff = newValue - arr[index];
        arr[index] = newValue;
        updateInternal(index + 1, diff);
    }

    int getSum(int index){
        int sum = 0;
        index++;
        while(index > 0){
            sum+=BIT[index];
            index-=(index & -index);
        }
        return sum;
    }

    int sumRange(int a, int b){
        if(a == 0)return getSum(b);
        return getSum(b)-getSum(a-1);
    }
}
class FenwickTree1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        FenWickTree ft = new FenWickTree(arr);

        while (Q-- > 0) {

            int option = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (option == 1) {

                System.out.println(ft.sumRange(a, b));
            }
            else if (option == 2) {

                ft.update(a, b);
            }
        }

        sc.close();
    }
}