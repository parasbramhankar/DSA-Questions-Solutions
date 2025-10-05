package LinkedList.SinglyLinkedList.Medium.Add1toaLinkedListNumber;

public class Solution {

    static Node reverse(Node head) {
        Node curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to add one to a linked list and
    // return the head node of the resultant list
    static Node addOneUtil(Node head) {
        Node res = head;
        Node curr = head;
        Node last = null;

        // Initialize carry with 1 (to add one)
        int carry = 1;
        int sum;

        while (curr != null) {

            // Calculate sum of carry
            // and current node's data
            sum = carry + curr.data;

            // Update carry for next digit
            carry = (sum >= 10) ? 1 : 0;

            // Update current node's data to sum modulo 10
            curr.data = sum % 10;

            // Move to the next node
            last = curr;
            curr = curr.next;
        }

        // If there's a carry left, add a new
        // node with carry value
        if (carry > 0) {
            last.next = new Node(carry);
        }

        return res;
    }

    // Main function to add one to the linked list
    static Node addOne(Node head) {

        // Reverse the linked list
        head = reverse(head);

        // Add one to the reversed list
        head = addOneUtil(head);

        // Reverse the list again to restore
        //the original order
        return reverse(head);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 9 -> 9 -> 9
        Node head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);

        head = addOne(head);

        printList(head);
    }
}