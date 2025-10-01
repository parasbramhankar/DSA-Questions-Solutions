package LinkedList.SinglyLinkedList.Easy.ReverseALinkedList206;

/*
    ********************************************************************************************
    APPROACH TO REVERSE A SINGLY LINKED LIST
    ********************************************************************************************

    Problem:
    We are given a singly linked list with nodes pointing from head → tail.
    The task is to reverse the list so that it points from tail → head.

    Example:
        Original: 1 → 2 → 3 → 4 → 5 → null
        Reversed: 5 → 4 → 3 → 2 → 1 → null

    ---------------------------------------------------------------------------------------------
    Core Idea:
    We reverse the linked list in-place using three references:
        - prev : Tracks the previous node of the current one
        - curr : Points to the node we’re currently processing
        - next : Temporarily stores the next node so we don’t lose access to the remaining list

    ---------------------------------------------------------------------------------------------
    Step-by-Step Logic:

    1. Initialize:
       - prev = null
       - curr = head

    2. Traverse while curr != null:
       Inside each loop iteration:

       (a) Save the next node:
           next = curr.next
           (we store the forward link first, otherwise it gets lost when reversing)

       (b) Reverse the pointer:
           curr.next = prev
           (the current node’s next is flipped to point to the previous node)

       (c) Shift prev forward:
           prev = curr
           (move prev so it’s ready for the next iteration)

       (d) Shift curr forward:
           curr = next
           (continue with the saved next node)

    3. After finishing:
       - curr becomes null (end of list reached)
       - prev now points to the new head of the reversed list
       - Return prev as the new head

    ---------------------------------------------------------------------------------------------
    Example Dry Run:

    Input: 1 → 2 → 3 → null

    Initial: prev = null, curr = 1

    Iteration 1:
        next = 2
        curr.next = prev → 1 → null
        prev = 1
        curr = 2

    Iteration 2:
        next = 3
        curr.next = prev → 2 → 1 → null
        prev = 2
        curr = 3

    Iteration 3:
        next = null
        curr.next = prev → 3 → 2 → 1 → null
        prev = 3
        curr = null (loop ends)

    Result:
        head = prev = 3

    ---------------------------------------------------------------------------------------------
    Time and Space Complexity:
    - Time Complexity: O(n), because each node is visited once.
    - Space Complexity: O(1), only constant variables (prev, curr, next) are used.

    ********************************************************************************************
*/

public class Solution {

    //  Step 1: Define ListNode class for a linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to reverse a singly linked list
    static ListNode reverseList(ListNode head) {

        // prev initially points to null, because the new tail of the list should point to null
        ListNode prev = null;

        // curr starts from the head of the original list
        ListNode curr = head;

        // Keep iterating until we have processed all nodes
        while (curr != null) {

            // Step 1: Save the next node before changing any links
            // (so we don’t lose access to the rest of the list)
            ListNode next = curr.next;

            // Step 2: Reverse the current node’s pointer
            // Instead of pointing forward, it now points back to prev
            curr.next = prev;

            // Step 3: Move prev one step forward
            // (prev becomes the current node we just processed)
            prev = curr;

            // Step 4: Move curr one step forward using the saved "next"
            // (this continues the loop to the next node of the original list)
            curr = next;
        }

        // At the end, prev points to the new head of the reversed list
        return prev;
    }


    //  Step 3: Utility method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //  Step 4: Main method to run and test the reverse logic
    public static void main(String[] args) {

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print original list
        System.out.println("Original Linked List:");
        printList(head);

        //Reverse the linked list
        ListNode reversedHead = reverseList(head);

        //Print reversed list
        System.out.println("\nReversed Linked List:");
        printList(reversedHead);
    }
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


