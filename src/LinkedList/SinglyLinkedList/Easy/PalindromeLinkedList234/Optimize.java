package LinkedList.SinglyLinkedList.Easy.PalindromeLinkedList234;


public class Optimize {

    // 🔁 Reverse the linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // 🔍 Find middle using slow and fast pointers
    static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // ✅ move fast 2 steps
            slow = slow.next;      // ✅ move slow 1 step
        }

        return slow; // Slow is at the middle
    }

    // ✅ Check if the list is a palindrome
    boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        ListNode middle = findMiddle(head);

        // Step 2: Reverse second half of the list
        ListNode secondHalfHead = reverseList(middle);

        // Step 3: Compare both halves
        ListNode first = head;
        ListNode second = secondHalfHead;

        while (second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }

        // (Optional) Step 4: Restore the list
        // middle = reverseList(secondHalfHead);

        return true;
    }
    // 🧪 Test the code
    public static void main(String[] args) {
        // 🔢 Create the linked list: 1 → 2 → 2 → 1
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))));

        // ✅ Create an object of Optimize class and check for palindrome
        Optimize sol = new Optimize();
        boolean result = sol.isPalindrome(head);

        // 🖨️ Output the result
        System.out.println("Is the linked list a palindrome? " + result);
    }
}
