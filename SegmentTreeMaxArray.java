// import java.util.*;

// class SegmentTreeMax {

//     int[] tree;   // segment tree
//     int[] arr;    // original array
//     int n;

//     // Constructor
//     SegmentTreeMax(int[] arr) {

//         this.arr = arr;
//         this.n = arr.length;

//         // allocate tree
//         tree = new int[4 * n];

//         // build tree
//         build(0, 0, n - 1);
//     }

//     // Build the segment tree
//     void build(int node, int start, int end) {

//         // Leaf node
//         if (start == end) {
//             tree[node] = arr[start];
//             return;
//         }

//         int mid = (start + end) / 2;

//         // build left subtree
//         build(2 * node + 1, start, mid);

//         // build right subtree
//         build(2 * node + 2, mid + 1, end);

//         // store maximum of children
//         tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
//     }

//     // Query maximum in range
//     int queryMax(int node, int start, int end, int left, int right) {

//         // Case 1: no overlap
//         if (right < start || left > end)
//             return Integer.MIN_VALUE;

//         // Case 2: complete overlap
//         if (left <= start && end <= right)
//             return tree[node];

//         // Case 3: partial overlap
//         int mid = (start + end) / 2;

//         int leftMax = queryMax(2 * node + 1, start, mid, left, right);
//         int rightMax = queryMax(2 * node + 2, mid + 1, end, left, right);

//         return Math.max(leftMax, rightMax);
//     }

//     // Wrapper function
//     int getMaxRange(int left, int right) {
//         return queryMax(0, 0, n - 1, left, right);
//     }

//     // Update value at index
//     void update(int node, int start, int end, int index, int value) {

//         // Leaf node
//         if (start == end) {
//             arr[index] = value;
//             tree[node] = value;
//             return;
//         }

//         int mid = (start + end) / 2;

//         if (index <= mid)
//             update(2 * node + 1, start, mid, index, value);
//         else
//             update(2 * node + 2, mid + 1, end, index, value);

//         // recompute parent
//         tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
//     }

//     // Wrapper update
//     void updateValue(int index, int value) {
//         update(0, 0, n - 1, index, value);
//     }

//     // Maximum of entire array
//     int getMax() {
//         return tree[0];
//     }
// }

// class SegmentTreeMaxArray {

//     public static void main(String[] args) {

//         int[] nums = {1, 3, 5, 7, 9, 11};

//         SegmentTreeMax st = new SegmentTreeMax(nums);

//         // range max query
//         System.out.println("Max in range [1,4]: " + st.getMaxRange(1,4));

//         // update index
//         st.updateValue(2,10);

//         // query again
//         System.out.println("Max in range [1,4] after update: " + st.getMaxRange(1,4));

//         // max of whole array
//         System.out.println("Max of entire array: " + st.getMax());
//     }
// }



import java.util.*;

class SegmentTree {

    int[] treeSum;
    int[] treeMin;
    int[] treeMax;
    int[] arr;
    int n;

    SegmentTree(int[] arr) {
        this.arr = arr;
        this.n = arr.length;

        treeSum = new int[4 * n];
        treeMin = new int[4 * n];
        treeMax = new int[4 * n];

        build(0, 0, n - 1);
    }

    // Build tree
    void build(int node, int start, int end) {

        if (start == end) {
            treeSum[node] = arr[start];
            treeMin[node] = arr[start];
            treeMax[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node + 1, start, mid);
        build(2 * node + 2, mid + 1, end);

        treeSum[node] = treeSum[2 * node + 1] + treeSum[2 * node + 2];
        treeMin[node] = Math.min(treeMin[2 * node + 1], treeMin[2 * node + 2]);
        treeMax[node] = Math.max(treeMax[2 * node + 1], treeMax[2 * node + 2]);
    }

    // SUM QUERY
    int sumQuery(int node, int start, int end, int l, int r) {

        if (r < start || l > end)
            return 0;

        if (l <= start && end <= r)
            return treeSum[node];

        int mid = (start + end) / 2;

        return sumQuery(2 * node + 1, start, mid, l, r) +
               sumQuery(2 * node + 2, mid + 1, end, l, r);
    }

    // MIN QUERY
    int minQuery(int node, int start, int end, int l, int r) {

        if (r < start || l > end)
            return Integer.MAX_VALUE;

        if (l <= start && end <= r)
            return treeMin[node];

        int mid = (start + end) / 2;

        return Math.min(
                minQuery(2 * node + 1, start, mid, l, r),
                minQuery(2 * node + 2, mid + 1, end, l, r)
        );
    }

    // MAX QUERY
    int maxQuery(int node, int start, int end, int l, int r) {

        if (r < start || l > end)
            return Integer.MIN_VALUE;

        if (l <= start && end <= r)
            return treeMax[node];

        int mid = (start + end) / 2;

        return Math.max(
                maxQuery(2 * node + 1, start, mid, l, r),
                maxQuery(2 * node + 2, mid + 1, end, l, r)
        );
    }

    // UPDATE
    void update(int node, int start, int end, int index, int value) {

        if (start == end) {
            arr[index] = value;
            treeSum[node] = value;
            treeMin[node] = value;
            treeMax[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid)
            update(2 * node + 1, start, mid, index, value);
        else
            update(2 * node + 2, mid + 1, end, index, value);

        treeSum[node] = treeSum[2 * node + 1] + treeSum[2 * node + 2];
        treeMin[node] = Math.min(treeMin[2 * node + 1], treeMin[2 * node + 2]);
        treeMax[node] = Math.max(treeMax[2 * node + 1], treeMax[2 * node + 2]);
    }

}

class SegmentTreeMaxArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        SegmentTree st = new SegmentTree(arr);

        while (Q-- > 0) {

            int option = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (option == 1) {
                System.out.println(st.sumQuery(0, 0, N - 1, a, b));
            }

            else if (option == 2) {
                st.update(0, 0, N - 1, a, b);
            }

            else if (option == 3) {
                System.out.println(st.minQuery(0, 0, N - 1, a, b));
            }

            else if (option == 4) {
                System.out.println(st.maxQuery(0, 0, N - 1, a, b));
            }
        }

        sc.close();
    }
}