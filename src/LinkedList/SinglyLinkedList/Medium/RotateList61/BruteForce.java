package LinkedList.SinglyLinkedList.Medium.RotateList61;

/*
=====================================
Approach & Logic for rotateRight (Brute Force)
=====================================

Problem:
--------
Given the head of a singly linked list and an integer k, rotate the list to the right by k places.

Key Observations:
-----------------
1. This is the **brute force** approach.
2. Instead of finding the new head directly, we perform the rotation step-by-step k times.
3. One rotation step = moving the last node to the front of the list.

Step-by-Step Logic:
-------------------
1. Handle edge cases:
   - If list is empty, has one node, or k == 0 → return head.

2. For i = 1 to k:
   a) Start from the head and find the second last node.
   b) Link the last node to the head.
   c) Update head to be the last node.
   d) Set the second last node's next to null.

3. After k steps, the list is rotated.

Time Complexity:
----------------
O(k × n) → For each of k rotations, we traverse n nodes to find the second last node.
- If k is large, this becomes slow.

Space Complexity:
-----------------
O(1) → Only uses pointers.

Example:
--------
List: 1 → 2 → 3 → 4 → 5, k = 2

First rotation:
Last node = 5 → new list: 5 → 1 → 2 → 3 → 4

Second rotation:
Last node = 4 → new list: 4 → 5 → 1 → 2 → 3
*/


public class BruteForce {

    public ListNode rotateRight(ListNode head, int k) {
        // Edge case: no rotation if list is empty, one node, or k is 0
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Perform rotation k times
        for (int i = 1; i <= k; i++) {
            // Start from head to find second last node
            ListNode temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            // temp is now the second last node
            // Move last node to the front
            temp.next.next = head; // last node points to head
            head = temp.next;      // update head to last node
            temp.next = null;      // break link from second last node
        }

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

        // Rotate list using brute force
        BruteForce sol = new BruteForce();
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