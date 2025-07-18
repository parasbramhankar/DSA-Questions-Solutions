package LinkedList.SinglyLinkedList.Easy.ReverseALinkedList206;

/**
 * Program: Reverse a Singly Linked List
 * Description: This program demonstrates how to reverse a singly linked list in Java
 * using an iterative approach with detailed explanations and dry run.
 */

public class Solution {

    // ✅ Step 1: Define ListNode class for a linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // ✅ Step 2: Function to reverse a singly linked list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;         // Previous node starts as null
        ListNode curr = head;         // Current node starts at head

        // 🔁 Traverse the list and reverse the links
        while (curr != null) {
            ListNode next = curr.next;  // Step 1: Save the next node
            curr.next = prev;           // Step 2: Reverse the pointer
            prev = curr;                // Step 3: Move prev forward
            curr = next;                // Step 4: Move curr forward
        }

        // ✅ prev now points to the new head of the reversed list
        return prev;
    }

    // ✅ Step 3: Utility method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // ✅ Step 4: Main method to run and test the reverse logic
    public static void main(String[] args) {

        // 🔸 Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 🔹 Print original list
        System.out.println("Original Linked List:");
        printList(head);

        // 🔄 Reverse the linked list
        ListNode reversedHead = reverseList(head);

        // 🔹 Print reversed list
        System.out.println("\nReversed Linked List:");
        printList(reversedHead);
    }

    /*
     🔍 DRY RUN EXPLANATION FOR LIST: 1 -> 2 -> 3 -> 4 -> 5 -> null

     Initial:
     prev = null
     curr = 1

     Iteration 1:
     next = 2
     1.next = null   (reversing link)
     prev = 1
     curr = 2

     Iteration 2:
     next = 3
     2.next = 1
     prev = 2
     curr = 3

     Iteration 3:
     next = 4
     3.next = 2
     prev = 3
     curr = 4

     Iteration 4:
     next = 5
     4.next = 3
     prev = 4
     curr = 5

     Iteration 5:
     next = null
     5.next = 4
     prev = 5
     curr = null

     Loop ends → return prev (which is now the new head: 5)
     */
}


