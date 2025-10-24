package LinkedList.SinglyLinkedList.Hard.ReverseNodesInkGroup25;

/**
 * Detailed Step-by-Step Explanation:
 * Group Reversal in Linked List using reverseKGroup
 *
 * This comment explains the process of reversing nodes in groups of k.
 * Example used: k = 3; input list = 1 -> 2 -> 3 -> 4 -> 5
 *
 * Step 1: Preparation
 * - Create and place a dummy node before the actual head of the list.
 *   This simplifies handling edge cases (like updating the head itself).
 * - Initialize pointers:
 *   - prevGroupEnd: tracks the node just before the current group to be reversed.
 *   - temp: points to the start of the current group to be processed.
 *
 * Step 2: Check for Enough Nodes
 * - Use a pointer (ptr) to move k steps ahead from temp.
 * - If at any point ptr hits null before completing k steps, there are not enough nodes left to reverse.
 *   In this case, stop and leave the remaining nodes unchanged.
 *
 * Step 3: Reverse Current Group
 * - Before reversal, mark the node after this group: nextGroupStart = ptr.next.
 *   This reference ensures you can reconnect the reversed group to the rest of the list.
 * - Reverse k nodes using a loop:
 *   - For each node:
 *      - Save next node: ListNode next = curr.next;
 *      - Redirect current node's next pointer: curr.next = prev;
 *        (Initially prev is nextGroupStart, so the new end points forward correctly.)
 *      - Move prev to current node, and curr to next node.
 *   - After the loop:
 *      - prev now points to the new head of the group.
 *      - temp is at the last node in the reversed segment (the original group start).
 *
 * Step 4: Connect Groups
 * - Link prior group to the newly reversed group: prevGroupEnd.next = prev.
 * - Prepare for the next round:
 *   - Move prevGroupEnd to temp (now the end of the reversed group).
 *   - Move temp to nextGroupStart (start of the next group to process).
 *
 * Step 5: Repeat Until List End or Not Enough Nodes Left
 * - Continue checking for k nodes, reversing them, and reconnecting, until fewer than k nodes remain.
 *   - Those remaining nodes (less than k) are left as is.
 *
 * Example Walkthrough (k=3; list 1 -> 2 -> 3 -> 4 -> 5):
 * - Identify group: nodes 1, 2, 3 (nextGroupStart = 4).
 * - Reverse pointers: new order is 3 -> 2 -> 1, 1.next points to 4.
 * - Connect: dummy's next pointer updated to 3 (new head).
 * - Move pointers for next iteration and repeat.
 * - Second pass: nodes 4, 5 (less than k), remain unchanged.
 * - Result: 3 -> 2 -> 1 -> 4 -> 5.
 *
 * Quick Summary:
 * - Only complete groups of k are reversed, structure and connectivity are preserved after each reversal.
 * - Any trailing nodes fewer than k remain in their original order.
 */


public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode temp = head;

        while (true) {
            ListNode ptr = temp;
            // Check there are k nodes
            for (int i = 1; i < k && ptr != null; i++) {
                ptr = ptr.next;
            }

            if (ptr == null){
                break; // Less than k nodes left
            }

            ListNode nextGroupStart = ptr.next;
            // Reverse k nodes
            ListNode prev = nextGroupStart;
            ListNode curr = temp;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            // Connect reversed group
            prevGroupEnd.next = prev;
            prevGroupEnd = temp;
            temp = nextGroupStart;
        }
        return dummy.next;
    }

    // Function to print a linked list
    static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Step 1: Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 5; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        System.out.println("Original List:");
        printList(head); // Output: 1 -> 2 -> 3 -> 4 -> 5

        // Step 2: Call reverseKGroup with k = 3
        int k = 2;
        ListNode newHead = reverseKGroup(head, k);

        System.out.println("List after reversing in groups of " + k + ":");
        printList(newHead);
    }
}