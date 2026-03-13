import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Solution{
    Node getmid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node middle = getmid(head);
        Node temp = middle.next;
        middle.next = reverse(temp);

        Node head1 = head;
        Node head2 = middle.next;

        while(head2!=null){
            if(head1.data!=head2.data){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        temp = middle.next;
        middle.next = reverse(temp);
        return true;
    }
}
class PalindromeList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr[] = sc.nextLine().split(" ");
        Node head = null;
        Node temp = null;

        for(int i = 0; i<arr.length; i++){
            Node newNode = new Node(Integer.parseInt(arr[i]));

            if(head == null){
                head = newNode;
                temp = newNode;
            }
            else{
                temp.next = newNode;
                temp = newNode;
            }
        }
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(head));
    }
}