package LinkedList.DoubleLinkedList.Easy.ReverseADLL;

/***
 * Approach Summary
 * To reverse a doubly linked list (DLL), we systematically swap the next and prev pointers of each node as we traverse the list:
 *
 * Traversal: Begin at the head node, visit each node once.
 *
 * Pointer Swap: For each node, swap its next and prev pointers.
 *
 * This means next becomes prev, and prev becomes next.
 *
 * Advance: To avoid losing track of the remaining nodes, save current.next before swapping, then move to the saved node after the swap.
 *
 * Final Step: When traversal completes (when current becomes null), the previous node (prev) points to the new head of the reversed list.
 * ------------------------------------------------------------------------------------------
 * Key Logic Breakdown
 * ------------------------------------------------------------------------------------------
 * Initialize pointers:
 *
 * prev is null (used for reversal).
 * current points to head.
 * next is a helper placeholder.
 *
 * Iterate through DLL:
 * a. Save next node: next = current.next.
 *
 * b. Reverse pointers:
 * current.next = prev (previous node becomes next of current).
 * current.prev = next (next node becomes previous of current).
 *
 * c. Move window:
 *
 * Set prev = current, current = next.
 *
 * Finish: Return prev (the new head).
 */

/**
 * Reverses a doubly linked list (DLL).
 *
 * Approach:
 *   - Traverse the list from the head node.
 *   - For each node, swap its next and prev pointers.
 *   - Continue until the end; the previous pointer refers to the new head.
 *
 * @ param head The head node of the DLL to reverse.
 * @ return The new head node of the reversed DLL.
 */

public class Solution {
    // Helper to print the doubly linked list
    static void printList(Node head) {
      Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper to create a linked list from array
    static Node createList(int[] arr) {
        if (arr.length == 0)
            return null;

        Node head = new Node(arr[0]);

        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            newNode.prev = curr;
            curr.next = newNode;
            curr=newNode;
        }

        return head;
    }

    public static Node reverse(Node head) {
        // Initialize pointers.
        Node prev = null;          // Tracks the reversed portion.
        Node next = null;          // Temporarily stores the next node.
        Node current = head;       // Starts traversal from the head.

        // Traverse the original DLL.
        while (current != null) {
            // Save the next node before changing pointers.
            next = current.next;

            // Swap the 'next' and 'prev' pointers.
            current.next = prev;   // Point 'next' to previous node.
            current.prev = next;   // Point 'prev' to next node.

            // Move 'prev' and 'current' one step forward.
            prev = current;        // 'prev' now becomes current node.
            current = next;        // 'current' moves to next node in original list.
        }

        // At the end, 'prev' points to the new head.
        return prev;
    }

    public static void main(String[] args) {

        // Example 1
        int[] arr = {2, 4, 5, 10, 3, 9, 12, 5};
        Node head = createList(arr);

        System.out.print("Before reversal Original List: ");
        printList(head);

        System.out.println();

        Node newHead=reverse(head);

        System.out.print("After reversal List: ");
        printList(newHead);





    }
}
