package LinkedList.SinglyLinkedList.Easy.PalindromeLinkedList234;

/**
 * ✅ Brute Force Approach to check if a Linked List is a Palindrome
 *
 * 🔴 Problem:
 * Given the head of a singly linked list, determine if the list is a palindrome.
 *
 * ✅ Brute Force Idea:
 * - A palindrome is a list that reads the same backward and forward.
 * - So, we reverse the entire list and compare it with the original list.
 *
 * ⚠️ Important Note:
 * - We should not reverse the original list directly because it will modify the structure.
 * - Instead, clone the original list first, then reverse the cloned list.
 *
 * ✅ Steps:
 * 1. Clone the entire original list to keep it unmodified.
 * 2. Reverse the cloned list.
 * 3. Compare both lists node by node.
 * 4. If all corresponding nodes match, the list is a palindrome.
 *
 * ✅ Time Complexity: O(N)
 * ✅ Space Complexity: O(N) — because we are cloning the list
 */

class BruteForce {

    // 🔁 Step 1: Clone the original list
    private ListNode cloneList(ListNode head) {
        if (head == null) return null;

        ListNode newHead = new ListNode(head.val);
        ListNode curr = newHead;
        head = head.next;

        while (head != null) {
            curr.next = new ListNode(head.val);
            curr = curr.next;
            head = head.next;
        }

        return newHead;
    }

    // 🔁 Step 2: Reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // New head of reversed list
    }

    // ✅ Step 3: Check if original and reversed lists are equal
    public boolean isPalindrome(ListNode head) {
        // Clone the original list
        ListNode copy = cloneList(head);

        // Reverse the cloned list
        ListNode reversed = reverseList(copy);

        // Compare both lists
        while (head != null && reversed != null) {
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }

    public static void main(String[] args) {
    // 🔢 Create the linked list: 1 → 2 → 2 → 1
       ListNode head = new ListNode(1,
                        new ListNode(2,
                                new ListNode(2,
                                        new ListNode(1))));

    // ✅ Create an object of Solution class and check for palindrome
       BruteForce sol = new BruteForce();
       boolean result = sol.isPalindrome(head);

      // 🖨️ Output the result
       System.out.println("Is the linked list a palindrome: ?\n" + result);
    }
}

