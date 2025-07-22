package LinkedList.SinglyLinkedList.Medium.RemoveMiddleNode2095;


/***
 * ✅ Problem Statement
 * ✅ Approach
 * ✅ Logic
 * ✅ Dry Run (step-by-step with example)
 * ✅ Java Code with full comments

 * ✅ Problem: Delete the Middle Node of a Singly Linked List
 *
 * Given the head of a singly linked list, delete the middle node,
 * and return the head of the modified list.
 *
 * If there are two middle nodes, delete the second middle node.
 *
 * ➤ Constraints:
 * - The list must contain at least one node.
 * - If the list has only one node, return null.
 *
 * ----------------------------------------------------------------
 * ✅ Approach:
 * Use the Fast and Slow pointer technique (also known as Tortoise-Hare).
 *
 * ➤ Step-by-step:
 * - Initialize two pointers: slow and fast.
 * - Move fast by 2 nodes and slow by 1 node.
 * - When fast reaches the end, slow will be just before the middle.
 * - Delete the middle node by: slow.next = slow.next.next;
 *
 * ----------------------------------------------------------------
 * ✅ Logic:
 * The idea is to find the middle node with only one traversal.
 *
 * Since we need to delete the middle node, it's best to stop the slow
 * pointer at the node **just before** the middle.
 *
 * That’s why fast starts at head.next.next to keep slow one step behind.
 *
 * ----------------------------------------------------------------
 * ✅ Example:
 * Input: 1 → 2 → 3 → 4 → 5
 *
 * ➤ Initial setup:
 * slow = head (1)
 * fast = head.next.next (3)
 *
 * ➤ Iteration 1:
 *     slow = 2
 *     fast = 5
 *
 * ➤ Iteration 2:
 *     fast.next == null → exit loop
 *     slow = 2, slow.next = 3 (middle)
 *
 * ➤ Deletion:
 *     slow.next = slow.next.next → skips 3
 *
 * Output: 1 → 2 → 4 → 5
 *
 * ----------------------------------------------------------------
 * ✅ Edge Cases:
 * - If the list is empty → return null
 * - If the list has only one node → return null
 *
 * ----------------------------------------------------------------
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(1)
 */

class Optimize {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: empty list or only one node
        if (head == null || head.next == null) {
            return null;
        }

        // Slow starts at head, fast starts two steps ahead
        ListNode slow = head;
        ListNode fast = head.next.next;

        // Move fast 2 steps and slow 1 step
        // When fast reaches end, slow is just before middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Delete the middle node
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return head;
    }

    // Utility method to display the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println(); // for newline after list
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(10);
        head.next=new ListNode(20);
        head.next.next=new ListNode(30);
        head.next.next.next=new ListNode(40);
        head.next.next.next.next=new ListNode(50);

        head=new Optimize().deleteMiddle(head);

        printList(head);



    }


}
