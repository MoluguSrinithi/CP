import java.util.*;

// Node class for Linked List
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class PalindromeCheck {

    // Function to check if linked list is palindrome
    public static boolean isPalindrome(Node head) {

        // If list has only one node
        if (head == null || head.next == null) {
            return true;
        }

        // STEP 1: Find middle of the list
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps
        }

        // STEP 2: Reverse second half of the list
        Node secondHalf = reverse(slow);

        // Keep a copy to restore later (optional)
        Node copySecondHalf = secondHalf;

        // STEP 3: Compare both halves
        Node firstHalf = head;

        while (secondHalf != null) {

            if (firstHalf.data != secondHalf.data) {
                return false;   // Not palindrome
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // STEP 4: Restore list (optional but good practice)
        reverse(copySecondHalf);

        return true;
    }

    // Function to reverse a linked list
    private static Node reverse(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;  // store next node
            current.next = prev;       // reverse link
            prev = current;            // move prev
            current = next;            // move current
        }

        return prev;  // new head after reverse
    }
}

public class PalindromeLinkedList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements separated by space:");

        String[] input = sc.nextLine().split(" ");

        Node head = null;
        Node tail = null;

        // Create Linked List
        for (String s : input) {

            int val = Integer.parseInt(s);
            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        boolean result = PalindromeCheck.isPalindrome(head);

        System.out.println(result);

        sc.close();
    }
}