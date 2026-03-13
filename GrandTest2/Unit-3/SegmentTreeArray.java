import java.util.*;

class SegmentTree{
    int[] tree;
    int [] arr;
    int n;
    SegmentTree(int[] arr){
        this.arr = arr;
        this.n = arr.length;
        tree = new int[4*n];
        build(0,0,n-1);
    }

    void build(int node, int start, int end){
        if(start == end){
            tree[node] = arr[start];
            return;
        }
        int mid = (start+end) /2;
        build(2 * node + 1 , start,mid);
        build(2 * node + 2 , mid+1 ,end);
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }

    int query(int node, int start, int end, int left, int right){
        if(right<start || left > end){
            return 0;
        }
        if(left <= start && right >= end){
            return tree[node];
        }
        int mid = (start+end)/2;
        int leftSum = query(2*node+1, start, mid, left, right);
        int rightSum = query(2*node+2, mid+1, end, left, right);

        return leftSum + rightSum;
    }

    void update(int node, int start, int end, int index, int value){
        if(start == end){
            arr[index] = value;
            tree[node] = value;
            return;
        }
        int mid = (start+end)/2;
        if(index<=mid){
            update(2*node+1, start, mid, index, value);
        }
        else{
            update(2*node+2, mid+1, end, index, value);
        }
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }

    int sumRange(int left, int right){
        return query(0,0,n-1,left,right);
    }

    void updateValue(int index, int value){
        update(0,0,n-1, index, value);
    }
}

public class SegmentTreeArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];

        // Input array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SegmentTree st = new SegmentTree(arr);

        while (q-- > 0) {

            int option = sc.nextInt();

            if (option == 1) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(st.sumRange(l, r));
            }

            else if (option == 2) {
                int index = sc.nextInt();
                int value = sc.nextInt();
                st.updateValue(index, value);
            }
        }

        sc.close();
    }
}