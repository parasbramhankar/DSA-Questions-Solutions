package LinkedList.SinglyLinkedList.Medium.FindTheLengthOfLoop;

import java.util.Scanner;

/**
 * ------------------------------------------------------------------
 *      Approach and Logic: Finding the Length of a Cycle in a Linked List
 * ------------------------------------------------------------------
 *
 * 1. Cycle Creation for Testing (createAList function):
 *      - A singly linked list is created from a given array of integers.
 *      - An optional cycle is introduced by connecting the last node
 *        to the node at the specified position (pos, 0-based index).
 *      - If pos == -1, no cycle is created, resulting in a normal acyclic list.
 *
 * 2. Cycle Detection (lengthOfLoop function):
 *      - This uses Floyd's Cycle-Finding Algorithm (Tortoise and Hare).
 *      - Two pointers are initialized at the head:
 *          - slow moves one step at a time.
 *          - fast moves two steps at a time.
 *      - If a cycle exists, fast and slow will eventually meet at some node in the cycle.
 *      - If there is no cycle, fast will reach the end (null).
 *
 * 3. Finding the Cycle Length:
 *      - Once slow and fast meet, keep slow moving one step at a time,
 *        counting the number of nodes until it meets fast again.
 *      - The counter records the length of the cycle.
 *      - If no cycle is found, the function returns 0.
 *
 * 4. Use Cases:
 *      - Demonstrates both cycle creation for testing and standard detection logic used in interviews and production.
 *      - This approach efficiently determines whether a cycle exists and, if so, its exact size, in O(n) time and O(1) space.
 *
 */

public class Solution {

    /**
     * Detects a cycle in a linked list and returns its length.
     * Uses Floyd's Tortoise and Hare algorithm.
     * If no cycle is found, returns 0.
     */
    public int lengthOfLoop(Node head) {
        Node fast = head; // Fast pointer (moves 2 steps)
        Node slow = head; // Slow pointer (moves 1 step)
        int count = 0;

        // Step 1: Detect cycle with two pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { // pointers meet: cycle exists
                break;
            }
        }

        // Step 2: If no cycle was found, return 0
        if (fast == null || fast.next == null) {
            return 0;
        } else {
            // Step 3: pointers met inside the cycle, count cycle length
            slow = slow.next;
            count = 1;
        }

        // Move slow until it again meets fast, counting nodes
        while (fast != slow) {
            count++;
            slow = slow.next;
        }
        return count; // Final count = cycle length
    }

    /**
     * Builds a singly linked list from 'arr'.
     * If pos != -1, creates a cycle from last node pointing to node at index pos.
     * If pos == -1, returns a standard acyclic list.
     */
    static Node createAList(int[] arr, int pos) {
        Node head = new Node(arr[0]);
        Node temp = head;
        int n = arr.length;
        // Build the list
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }

        // If pos == -1, no cycle
        if (pos == -1) {
            return head;
        }

        // Find the cycle start node (at 'pos')
        Node dummy = head;
        int i = 0;
        while (i < pos) {
            dummy = dummy.next;
            i++;
        }
        // Link last node's next to 'dummy' at 'pos'
        temp.next = dummy;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the position of the cycle creating node (use -1 for no cycle): ");
        int pos = scanner.nextInt();
        // Build the list and create cycle if needed
        Node head = createAList(arr, pos);

        Solution solution = new Solution();
        int count = solution.lengthOfLoop(head); // Detect cycle, get length

        System.out.println("The number of nodes in the cycle: " + count);
    }
}

