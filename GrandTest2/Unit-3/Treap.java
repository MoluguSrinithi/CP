import java.util.*;
class TreapNode{
    int key, priority;
    TreapNode left, right;
}

class Treap{
    public static TreapNode rightRotate(TreapNode y){
        TreapNode x = y.left;
        TreapNode T2 = x.right;
        x.right = y;
        y.left = T2;
        return x;
    }

    public static TreapNode rotateLeft(TreapNode x){
        TreapNode y = x.right;
        TreapNode T2 = y.left;

        y.left = x;
        x.right = T2;
        return y;
    }

    public static TreapNode newNode(int key){
        TreapNode temp = new TreapNode();
        temp.key = key;
        temp.priority = (int)(Math.random() * 100);
        temp.left = temp.right = null;
        return temp;
    }

    public static TreapNode insertNode(TreapNode root, int key){
        if(root == null){
            return newNode(key);
        }

        if(key <= root.key){
            root.left = insertNode(root.left, key);
            if(root.left.priority > root.priority){
                root = rightRotate(root);
            }

        }
        else{
            root.right = insertNode(root.right, key);
            if(root.right.priority> root.priority){
                root = rotateLeft(root);
            }
        }
        return root;
    }

    public static TreapNode deleteNode(TreapNode root, int key){
        if(root == null){
            return root;
        }
        if(root.key > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.key < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null){
                root = root.right;
            }
            else if(root.right == null){
                root = root.left;
            }
            else if(root.left.priority < root.right.priority){
                root = rotateLeft(root);
                root.left = deleteNode(root.left, key);

            }
            else{
                root = rightRotate(root);
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }

    public static TreapNode search(TreapNode root, int key){
        if(root == null || root.key == key){
            return root;
        }
        if(root.key< key){
            return search(root.right, key);
        }
        return search(root.left, key);
    }

    static void preorder(TreapNode root){
        if(root!=null){
            System.out.println("key: " + root.key + " | priority: " + root.priority);
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreapNode root = null;

        for (int a : arr) {
            root = insertNode(root, a);
        }

        preorder(root);

        System.out.println("Enter item to search ");
        int key = sc.nextInt();

        TreapNode result = search(root, key);

        if (result != null) {
            System.out.println("Search result " + result.key + " " + result.priority);
        } else {
            System.out.println("Key " + key + " not found");
        }

        do {

            System.out.println("Enter item to delete ");
            key = sc.nextInt();

            if (key == -1)
                break;

            root = deleteNode(root, key);

            System.out.println("After delete");
            preorder(root);

        } while (root != null);

    }
}