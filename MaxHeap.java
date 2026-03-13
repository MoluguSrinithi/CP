/*
Design and implement a Max Heap data structure using an array in Java.
In a Max Heap, every parent node is greater than or equal to its child nodes, 
ensuring that the largest element is always at the root.

Sample Input:
-------------
5
1 2 3 4 5

Sample Output:
-------------
The max value is 5

*/
import java.util.*;

public class MaxHeap {
    private int[] Heap;
    private int size;

    // Constructor to initialize an empty max heap
    public MaxHeap(int maxsize) {
        this.size = 0;
        Heap = new int[maxsize];
    }

    // Return the index of the parent
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    // Return the index of the left child
    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    // Return the index of the right child
    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    // Check if the node at pos is a leaf node
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos < size) {
            return true;
        }
        return false;
    }

    // Swap nodes at positions fpos and spos
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Recursive function to max heapify the subtree at index pos
    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int largest = pos;

            if (left < size && Heap[left] > Heap[largest]) {
                largest = left;
            }

            if (right < size && Heap[right] > Heap[largest]) {
                largest = right;
            }

            if (largest != pos) {
                swap(pos, largest);
                maxHeapify(largest);
            }
        }
    }

    // Insert a new element into the max heap
    public void insert(int element) {
        Heap[size] = element;
        int current = size;
        size++;

        while (current > 0 && Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Remove and return the maximum element from the heap
    public int extractMax() {
        int popped = Heap[0];
        Heap[0] = Heap[size - 1];
        size--;
        maxHeapify(0);
        return popped;
    }

    // Display heap structure
    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent: " + Heap[i]);
            if (leftChild(i) < size)
                System.out.print(" Left Child: " + Heap[leftChild(i)]);
            if (rightChild(i) < size)
                System.out.print(" Right Child: " + Heap[rightChild(i)]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        MaxHeap maxHeap = new MaxHeap(n);

        for (int i = 0; i < n; i++) {
            maxHeap.insert(scan.nextInt());
        }

        System.out.println("The max value is " + maxHeap.extractMax());
    }
}