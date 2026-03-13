/*
Implement a Treap data structure that performs the following operations:
-Insert elements into the Treap.
-Display all nodes (key and priority).
-Search for a given element.
-Delete a given element.
-Display the updated Treap after deletion.

Input Format:
------------
An integer n — number of elements to insert.
n space-separated integers — keys to be inserted into the Treap.
An integer — key to search.
One or more integers — keys to delete.
Enter -1 to stop deletion.

Output Format:
-------------
Display the Preorder Traversal of the Treap after insertion.
Display the search result 
After each deletion, display:After delete; 
followed by the preorder traversal of the updated Treap.

Sample Input - 1:
-----------------
6
2 4 3 1 7 5
3
4
-1

Sample Output - 1:
-------------------
Key: 4 Priority: 87
Key: 2 Priority: 65
Key: 1 Priority: 22
Key: 3 Priority: 70
Key: 7 Priority: 50
Key: 5 Priority: 15

Element found: 3 with Priority: 70

Treap after deletion:
Key: 3 Priority: 70
Key: 2 Priority: 65
Key: 1 Priority: 22
Key: 7 Priority: 50
Key: 5 Priority: 15
*/
import java.util.*;

public class Treap {

    class Node {
        int key, priority;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.priority = new Random().nextInt(100) + 1;
            this.left = this.right = null;
        }
    }

    public Node root;

    public Node rightRotate(Node y) {
        Node x = y.left;
        Node t = x.right;

        x.right = y;
        y.left = t;

        return x;
    }

    public Node leftRotate(Node x) {
        Node y = x.right;
        Node t = y.left;

        y.left = x;
        x.right = t;

        return y;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
            if (root.left.priority > root.priority) {
                root = rightRotate(root);
            }
        } else if (key > root.key) {
            root.right = insert(root.right, key);
            if (root.right.priority > root.priority) {
                root = leftRotate(root);
            }
        }

        return root;
    }

    public Node search(int key) {
        return search(root, key);
    }

    public Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null && (root.right == null || root.left.priority > root.right.priority)) {
                root = rightRotate(root);
                root.right = delete(root.right, key);
            } else {
                root = leftRotate(root);
                root.left = delete(root.left, key);
            }
        }

        return root;
    }

    public void preorder() {
        preorder(root);
    }

    public void preorder(Node root) {
        if (root != null) {
            System.out.println("Key: " + root.key + " Priority: " + root.priority);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Treap treap = new Treap();

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            treap.insert(scan.nextInt());
        }

        treap.preorder();

        int searchKey = scan.nextInt();
        Node found = treap.search(searchKey);

        if (found != null) {
            System.out.println();
            System.out.println("Element found: " + found.key + " with Priority: " + found.priority);
        } else {
            System.out.println();
            System.out.println("Element not found");
        }

        while (true) {
            int delKey = scan.nextInt();
            if (delKey == -1) {
                break;
            }

            treap.delete(delKey);
            System.out.println();
            System.out.println("Treap after deletion:");
            treap.preorder();
        }
    }
}