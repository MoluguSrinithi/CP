/*
1. Write a Java program to implement a Trie (Prefix Tree) that stores a set of 
lowercase English words.
The program should support operations such as Insert, Search, Delete and Display.

Initially, the program reads a line containing words separated by spaces and 
inserts them into the Trie.
After constructing the Trie, the program should repeatedly accept numeric 
options from the user to perform the following operations:

1.Insert – Insert a new word into the Trie.
2.Search – Check whether a given word exists in the Trie.
3.Delete – Delete a word from the Trie if it exists.
4.Display – Display all the words currently stored in the Trie.
5.Exit – Terminate the program.

All words consist only of lowercase English letters (a–z).

Input Format:
------------
- A list of words separated by spaces to initialize the Trie.
- A number representing the operation to be performed.
- If the option is 1, 2, or 3, the next input will be a word related to that 
operation.
- The last input will always be 5, which terminates the program.

Output Format:
-------------
- The program should display appropriate messages based on the operation 
performed.
- After Insert, display the updated content of the Trie.
- For Search, print whether the word is present or not.
- After Delete print whether deletion was successful and display the updated 
Trie.
- For Display, print all words currently stored in the Trie.

Example 1:
---------
Input
-----
apple ape ant animal
4
2 apple
1 ball
3 ape
4
5

Output
------
//(4)
Content of Trie:
animal
ant
ape
apple

//(2)
apple is present

//(1)
Content of Trie:
animal
ant
ape
apple
ball

//(3)
ape is deleted

//(3)
Content of Trie after deletion:
animal
ant
apple
ball

//(4)
Content of Trie:
animal
ant
apple

*/
import java.util.*;

class Trie {

    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    static TrieNode root;

    // Insert
    static void insert(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (curr.children[index] == null)
                curr.children[index] = new TrieNode();

            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    // Search
    static boolean search(String key) {
        TrieNode curr = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (curr.children[index] == null)
                return false;

            curr = curr.children[index];
        }

        return curr != null && curr.isEndOfWord;
    }

    // Check empty node
    static boolean isEmpty(TrieNode node) {
        for (int i = 0; i < ALPHABET_SIZE; i++)
            if (node.children[i] != null)
                return false;

        return true;
    }

    // Delete
    static TrieNode delete(TrieNode node, String key, int depth) {

        if (node == null)
            return null;

        if (depth == key.length()) {

            if (node.isEndOfWord)
                node.isEndOfWord = false;

            if (isEmpty(node))
                return null;

            return node;
        }

        int index = key.charAt(depth) - 'a';

        node.children[index] =
                delete(node.children[index], key, depth + 1);

        if (isEmpty(node) && !node.isEndOfWord)
            return null;

        return node;
    }

    // Display words
    static void display(TrieNode node, String word) {

        if (node.isEndOfWord)
            System.out.println(word);

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.children[i] != null) {
                char ch = (char) (i + 'a');
                display(node.children[i], word + ch);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        root = new TrieNode();

        // Initial words
        String[] words = sc.nextLine().split(" ");

        for (String w : words)
            insert(w);

        while (true) {

            int option = sc.nextInt();

            if (option == 1) {

                String word = sc.next();
                insert(word);

                System.out.println("Content of Trie:");
                display(root, "");

            } else if (option == 2) {

                String word = sc.next();

                if (search(word))
                    System.out.println(word + " is present");
                else
                    System.out.println(word + " is not present");

            } else if (option == 3) {

                String word = sc.next();

                if (search(word)) {
                    root = delete(root, word, 0);
                    System.out.println(word + " is deleted");

                    System.out.println("Content of Trie after deletion:");
                    display(root, "");
                } else {
                    System.out.println(word + " is not present");
                }

            } else if (option == 4) {

                System.out.println("Content of Trie:");
                display(root, "");

            } else if (option == 5) {
                break;
            }
        }
    }
}