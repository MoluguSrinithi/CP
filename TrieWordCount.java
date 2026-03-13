/*
Design and implement a Trie (Prefix Tree) to store a collection of lowercase 
words (a–z).
The Trie should allow duplicate word insertions and maintain the frequency of 
each word using a counter at the EndOfWord node.

The program should perform the following operations:
-Insert Words
-Display Words with Frequency
-Delete a Word
When a word is deleted, decrease its frequency by 1.
If the frequency becomes 0, remove the word completely from the Trie.
Display Updated Frequencies
After deletion, print the updated list of words and their frequencies.
-Exit the program.

Example:
--------
Enter words:
hell hello and and and hell and and and

Words with Frequency:
and : 6
hell : 2
hello : 1

1.Delete Word
2.Display
3.Exit
1
Enter word to delete:
and

Updated Trie:
and : 5
hell : 2
hello : 1
*/
import java.util.*;

public class TrieWordCount
{
    static final int NUM_CHARS = 26;

    // Trie Node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[NUM_CHARS];
        boolean isEndOfWord;
        int frequency;

        TrieNode()
        {
            isEndOfWord = false;
            frequency = 0;

            for(int i=0;i<NUM_CHARS;i++)
                children[i] = null;
        }
    }

    static TrieNode root;

    // Insert word
    static void insertWord(String word)
    {
        TrieNode current = root;

        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i) - 'a';

            if(current.children[index] == null)
                current.children[index] = new TrieNode();

            current = current.children[index];
        }

        current.isEndOfWord = true;
        current.frequency++;   // increase frequency
    }

    // Delete word
    static TrieNode deleteWord(TrieNode root, String word, int depth)
    {
        if(root == null)
            return null;

        if(depth == word.length())
        {
            if(root.isEndOfWord)
            {
                root.frequency--;

                if(root.frequency == 0)
                    root.isEndOfWord = false;
            }

            if(!root.isEndOfWord && !hasChildren(root))
                return null;

            return root;
        }

        int index = word.charAt(depth) - 'a';

        root.children[index] =
                deleteWord(root.children[index], word, depth + 1);

        if(!root.isEndOfWord && !hasChildren(root))
            return null;

        return root;
    }

    // Check if node has children
    static boolean hasChildren(TrieNode node)
    {
        for(int i=0;i<NUM_CHARS;i++)
            if(node.children[i] != null)
                return true;

        return false;
    }

    // Display words with frequency
    static void displayWordsWithFrequency(TrieNode root, char[] word, int level)
    {
        if(root.isEndOfWord)
        {
            for(int i=0;i<level;i++)
                System.out.print(word[i]);

            System.out.println(" : " + root.frequency);
        }

        for(int i=0;i<NUM_CHARS;i++)
        {
            if(root.children[i] != null)
            {
                word[level] = (char)(i + 'a');
                displayWordsWithFrequency(root.children[i], word, level + 1);
            }
        }
    }

    // Build Trie from input words
    static void buildTrie(String[] words)
    {
        for(String w : words)
            insertWord(w);
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        root = new TrieNode();

        System.out.println("Enter words:");
        String[] words = sc.nextLine().split(" ");

        buildTrie(words);

        char[] word = new char[50];

        System.out.println("\nWords with Frequency:");
        displayWordsWithFrequency(root, word, 0);

        while(true)
        {
            System.out.println("\n1.Delete Word");
            System.out.println("2.Display");
            System.out.println("3.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    System.out.println("Enter word to delete:");
                    String deleteWord = sc.nextLine();

                    root = deleteWord(root, deleteWord, 0);

                    System.out.println("\nUpdated Trie:");
                    displayWordsWithFrequency(root, word, 0);
                    break;

                case 2:
                    System.out.println("\nWords with Frequency:");
                    displayWordsWithFrequency(root, word, 0);
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    System.exit(0);
            }
        }
    }
}