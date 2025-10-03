package LinkedList.SinglyLinkedList.Medium.OddEvenLinkedList328;



/*
 * ---------------------------------------------------------
 * Approach and Logic: Odd-Even Linked List Rearrangement
 * ---------------------------------------------------------
 *
 * Problem: Rearrange a singly linked list so that all nodes at odd indices
 * appear before nodes at even indices, preserving relative order within each group.
 *
 * Step-by-step Approach:
 * 1. Edge Cases:
 *    - If the list is empty or has only one node, return head immediately.
 *
 * 2. Initialize Pointers:
 *    - "odd" pointer starts at the first node (head).
 *    - "even" pointer starts at the second node (head.next).
 *    - Keep a reference "evenHead" to the start of even nodes for later linking.
 *
 * 3. Rearrangement Loop:
 *    - While even and even.next are not null:
 *        a) Link odd.next to the node after even (i.e., odd.next = even.next),
 *           effectively skipping the even node.
 *        b) Move odd forward to odd.next.
 *        c) Link even.next to odd.next (next even node), skipping the odd node.
 *        d) Move even forward to even.next.
 *
 * 4. Final Connection:
 *    - Append the even nodes list (evenHead) after the last odd node by setting odd.next = evenHead.
 *
 * 5. Return:
 *    - Return the head of the modified list.
 *
 * Time Complexity: O(n), single pass through the list.
 * Space Complexity: O(1), rearranging pointers in-place without extra data structures.
 *
 * ------------------------------------------------------------------------
 * Dry Run Example with Input: 1 → 2 → 3 → 4 → 5
 * ------------------------------------------------------------------------
 * Initialization:
 *    odd = 1, even = 2, evenHead = 2
 *
 * Iteration 1:
 *    odd.next = even.next → odd.next = 3; list now: 1 → 3 → 4 → 5
 *    odd = odd.next → odd = 3
 *    even.next = odd.next → even.next = 4
 *    even = even.next → even = 4
 *
 * Iteration 2:
 *    odd.next = even.next → odd.next = 5; list updated: 1 → 3 → 5
 *    odd = odd.next → odd = 5
 *    even.next = odd.next → even.next = null
 *    even = even.next → even = null (loop ends)
 *
 * Final Step:
 *    odd.next = evenHead → 5.next = 2
 *    Final list: 1 → 3 → 5 → 2 → 4
 *
 * This moves all nodes at odd positions first, followed by nodes at even positions,
 * preserving original relative order within each group.
 */

public class Optimize {
    ListNode oddEvenList(ListNode head){

        if(head==null || head.next==null){
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=even;

        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;

            even.next=odd.next;
            even=even.next;
        }

        odd.next=evenHead;

        return head;
    }
    // Helper: Convert an array to linked list
    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper: Print linked list
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" → ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(input);

        BruteForce solution = new BruteForce();
        ListNode result = solution.oddEvenList(head);

        System.out.print("Output: ");
        printLinkedList(result);  // Expected: 1 → 3 → 5 → 2 → 4
    }
}

