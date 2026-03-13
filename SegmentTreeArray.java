import java.util.*;

class SegmentTree {

    int[] tree;   // Segment tree array
    int[] arr;    // Original array
    int n;        // Size of array

    // Constructor
    SegmentTree(int[] arr) {
        this.arr = arr;
        this.n = arr.length;

        // Allocate enough space for tree
        tree = new int[4 * n];

        // Build the segment tree
        build(0, 0, n - 1);
    }

    // Build the segment tree
    void build(int node, int start, int end) {

        // Leaf node
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        // Build left subtree
        build(2 * node + 1, start, mid);

        // Build right subtree
        build(2 * node + 2, mid + 1, end);

        // Store sum of children
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    // Range Sum Query
    int query(int node, int start, int end, int left, int right) {

        // Case 1: No overlap
        if (right < start || left > end)
            return 0;

        // Case 2: Complete overlap
        if (left <= start && end <= right)
            return tree[node];

        // Case 3: Partial overlap
        int mid = (start + end) / 2;

        int leftSum = query(2 * node + 1, start, mid, left, right);
        int rightSum = query(2 * node + 2, mid + 1, end, left, right);

        return leftSum + rightSum;
    }

    // Update value at index
    void update(int node, int start, int end, int index, int value) {

        // Leaf node
        if (start == end) {
            arr[index] = value;
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        // Go to correct child
        if (index <= mid)
            update(2 * node + 1, start, mid, index, value);
        else
            update(2 * node + 2, mid + 1, end, index, value);

        // Update current node
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    // Wrapper function for query
    int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    // Wrapper function for update
    void updateValue(int index, int value) {
        update(0, 0, n - 1, index, value);
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