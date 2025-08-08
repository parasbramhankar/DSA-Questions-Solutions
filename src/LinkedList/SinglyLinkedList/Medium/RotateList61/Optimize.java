/*
=====================================
Approach & Logic for rotateRight
=====================================

Problem:
--------
Given the head of a singly linked list and an integer k, rotate the list to the right by k places.

Key Observations:
-----------------
1. Rotating right by k means taking the last k nodes and moving them to the front.
2. Rotating by the length of the list (n) results in the same list → only rotate by k % n.
3. Instead of moving nodes one-by-one (O(k × n) brute force), we can:
   - Find the length of the list (n).
   - Link the last node to the head (make it circular).
   - Find the new head position in one pass.
   - Break the circle.

Step-by-Step Logic:
-------------------
1. Handle edge cases:
   - If the list is empty, has one node, or k == 0 → return head (no rotation needed).

2. Find the length (n) and tail node:
   - Traverse the list counting nodes.
   - Keep track of the last node (tail).

3. Make the list circular:
   - tail.next = head.

4. Adjust k:
   - k = k % n (avoids unnecessary full rotations).

5. Find the new head position:
   - The new head will be at (n - k)th node (1-based index).
   - Traverse (n - k - 1) steps from current head to get node before new head.

6. Break the circle:
   - newHead = current.next
   - current.next = null

Time Complexity:
----------------
O(n) → single traversal to find length + single traversal to break circle.

Space Complexity:
-----------------
O(1) → constant extra space.

Example:
--------
List: 1 → 2 → 3 → 4 → 5, k = 2
n = 5
k % n = 2
stepsToNewHead = 5 - 2 = 3
New list: 4 → 5 → 1 → 2 → 3
*/

package LinkedList.SinglyLinkedList.Medium.RotateList61;

public class Optimize {

    public ListNode rotateRight(ListNode head, int k) {
        // Edge case: No rotation if list is empty, has one node, or k is 0
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length of list and last node
        ListNode temp = head;
        int count = 1; // Start with 1 since we already have head
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        // temp now points to last node (tail)
        // Step 2: Make the list circular
        temp.next = head;

        // Step 3: Adjust k to avoid unnecessary rotations
        k = k % count;
        int stepsToNewHead = count - k; // position of new head

        // Step 4: Find node before the new head
        temp = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            temp = temp.next;
        }

        // Step 5: Break the circle
        head = temp.next; // new head after rotation
        temp.next = null; // break circular link

        return head;
    }

    public static void main(String[] args) {
        // Create linked list: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        // Print original list
        System.out.println("Original List:");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        // Rotate list
        Optimize sol = new Optimize();
        ListNode newHead = sol.rotateRight(head, k);

        // Print rotated list
        System.out.println("\nNew List:");
        temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
