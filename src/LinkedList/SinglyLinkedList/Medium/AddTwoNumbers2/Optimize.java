/**
 * ✅ Problem: Add Two Numbers (LeetCode 2)
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 *
 * ➤ Add the two numbers and return the result as a linked list in the same reverse order.
 * ➤ You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * ----------------------------------------------------------------
 * ✅ Example:
 * Input:
 *     l1 = 2 → 4 → 3   // Represents 342
 *     l2 = 5 → 6 → 4   // Represents 465
 *
 * Output:
 *     7 → 0 → 8        // Represents 807
 *
 * Explanation:
 *   342 + 465 = 807
 *   So the result list is 7 → 0 → 8
 *
 * ----------------------------------------------------------------
 * ✅ Approach:
 * - Use a dummy node to simplify the list construction.
 * - Use a `carry` variable to handle overflow (when sum >= 10).
 * - Traverse both linked lists simultaneously.
 * - For each pair of digits (or zero if one list is shorter), calculate:
 *     - sum = val1 + val2 + carry
 *     - digit = sum % 10
 *     - carry = sum / 10
 * - Add the digit to the result list.
 * - Continue the loop until both lists and carry are exhausted.
 *
 * ----------------------------------------------------------------
 * ✅ Dry Run of Example:
 *
 * l1: 2 → 4 → 3
 * l2: 5 → 6 → 4
 *
 * Iteration 1:
 *     sum = 2 + 5 + 0 = 7 → digit = 7, carry = 0
 *     result = 7
 *
 * Iteration 2:
 *     sum = 4 + 6 + 0 = 10 → digit = 0, carry = 1
 *     result = 7 → 0
 *
 * Iteration 3:
 *     sum = 3 + 4 + 1 = 8 → digit = 8, carry = 0
 *     result = 7 → 0 → 8
 *
 * Final Output: 7 → 0 → 8
 *
 * ----------------------------------------------------------------
 * ✅ Time Complexity: O(max(m, n))
 * ✅ Space Complexity: O(max(m, n))
 * Where m and n are lengths of l1 and l2
 */

package LinkedList.SinglyLinkedList.Medium.AddTwoNumbers2;

public class Optimize {

    // Optimized method to add two numbers represented as reversed linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify result list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // Add current digit from l1 if available
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            // Add current digit from l2 if available
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            // Calculate the digit and update carry
            int digit = sum % 10;
            carry = sum / 10;

            // Add the digit as a new node in result list
            current.next = new ListNode(digit);
            current = current.next;
        }

        // Return the head of the new list (skipping dummy node)
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create first linked list: 2 → 4 → 3 (represents 342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second linked list: 5 → 6 → 4 (represents 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Call the addTwoNumbers method from Optimize class
        Optimize solution = new Optimize();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result: should be 7 → 0 → 8
        System.out.print("Result: ");
        printList(result);
    }
    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" → ");
            }
            temp = temp.next;
        }
        System.out.println(); // for new line
    }
}
