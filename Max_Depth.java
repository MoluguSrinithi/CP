/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the 
longest path from the root node down to the farthest leaf node.

Input Format:
--------------
Line-1: An integer n, the number of nodes (tokens) in the tree.
Line-2: n space-separated tokens representing the tree in level-order traversal 
        (use "null" for missing children).

Output Format:
---------------
Line-1: A single integer representing the maximum depth of the binary tree.


Constraints:
------------
*The number of nodes in the tree is in the range [0, 2000].
*-100 ≤ Node.val ≤ 100.

Sample Input-1:
---------------
7
3 9 20 null null 15 7

Sample Output-1:
-----------------
3

Sample Input-2:
---------------
1
1

Sample Output-2:
----------------
1

*/
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class Max_Depth {
    // Build tree from level-order input with "null"
    private static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            if (i < nodes.length && !nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    // Calculate max depth
    public static int maxDepth(TreeNode root) {
        //WRITE YOUR CODE HERE
        if(root == null)return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1+Math.max(l,r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        String[] nodes = new String[n];
        if (n > 0) {
            nodes = sc.nextLine().split(" ");
        }

        TreeNode root = buildTree(nodes);
        System.out.println(maxDepth(root));
    }
}
