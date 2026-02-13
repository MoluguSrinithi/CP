/*You are given the root of a binary tree.
Return the zigzag level order traversal of its nodes' values.
(That is, from left to right, then right to left for the next level, 
and alternate between.)

Input Format:
--------------
Line-1: An integer n, number of nodes in the tree.
Line-2: n space-separated integers representing the tree in level-order format 
        (use "null" for empty nodes).


Output Format:
---------------
Line-1: Print a list of lists, each representing a level in zigzag order.

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
[[3], [20, 9], [15, 7]]

Sample Input-2:
---------------
1
1


Sample Output-2:
----------------
[[1]]

*/
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class ZigZag {

    // Build tree from level-order array with "null"
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

    // Zigzag level order traversal
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //WRITE YOUR CODE HERE AND RETURN LIST
        if(root == null)return 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        String[] nodes = sc.nextLine().split(" ");

        TreeNode root = buildTree(nodes);

        List<List<Integer>> ans = zigzagLevelOrder(root);
        System.out.println(ans);
    }
}
