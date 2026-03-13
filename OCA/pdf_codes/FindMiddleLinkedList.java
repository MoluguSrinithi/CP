import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindMiddleLinkedList {

    // Function to find middle element
    public static int findMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        // Move fast by 2 and slow by 1
        while (fast != null && fast.next != null) {

            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps
        }

        return slow.data;  // slow will be at middle
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        Node head = null;
        Node temp = null;

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {

            int val = sc.nextInt();
            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
                temp = head;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        int middle = findMiddle(head);

        System.out.println("Middle Element: " + middle);
    }
}