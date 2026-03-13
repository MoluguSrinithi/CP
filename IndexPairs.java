import java.util.*;

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean end;
}

public class IndexPairs {

    static TrieNode root = new TrieNode();

    static void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.child[i] == null) node.child[i] = new TrieNode();
            node = node.child[i];
        }
        node.end = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = sc.nextLine().split(" ");

        for (String w : words) insert(w);

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            TrieNode node = root;
            for (int j = i; j < text.length(); j++) {
                int idx = text.charAt(j) - 'a';
                if (node.child[idx] == null) break;
                node = node.child[idx];
                if (node.end) res.add(new int[]{i, j});
            }
        }

        Collections.sort(res, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int[] p : res) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}