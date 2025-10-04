package LinkedList.SinglyLinkedList.Easy.Intersection;



/**
 * Approach and Logic: Find Intersection of Two Linked Lists
 *
 * This solution uses the two-pointer technique to efficiently find the intersection node of two singly-linked lists, if one exists.
 *
 * Steps:
 * 1. Initialize Two Pointers:
 *    - Create two pointers, `pA` on `headA` and `pB` on `headB`, which will traverse both lists.
 *
 * 2. Traverse the Lists:
 *    - Move both pointers one step at a time (`pA = pA.next`, `pB = pB.next`).
 *    - When a pointer reaches the end of its list (`null`), redirect it to the head of the other list.
 *    - This gives each pointer a chance to walk the total combined length of both lists, bringing them to the intersection if one exists.
 *
 * 3. Detect Intersection or End:
 *    - The loop continues until `pA == pB`.
 *    - If the linked lists intersect, both pointers will meet at the intersection node after at most `m + n` steps (where `m` and `n` are the lengths of lists).
 *    - If not, both pointers will end up at `null` together, and there is no intersection.
 *
 * What makes this approach efficient:
 * - No need to count lengths or use extra space.
 * - O(m+n) time, O(1) space: Every node is visited at most twice, and only two pointers are used.
 *
 * Example:
 * - List A: `1 -> 2 -> 3 -> 4 -> 5`
 * - List B: `9 -> 4 -> 5` (intersect at node with value 4)
 * - Pointers will synchronize at node 4 after traversing both lists.
 */


public class Optimize {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA; // Initialize pointer A to the head of list A. It's one of our runners.
        ListNode pointerB = headB; // Initialize pointer B to the head of list B. This is our second runner.

        while (pointerA != pointerB) { // Keep going until our runners meet! Or until we're absolutely sure they won't meet.
            if (pointerA == null) { // If runner A reaches the end of its track...
                pointerA = headB; // ...it starts running on track B! It's like saying "Okay, let's see if we can meet if I run the other way".
            } else {
                pointerA = pointerA.next; // Otherwise, runner A continues to the next node on its track. Just keep running!
            }

            if (pointerB == null) { // Same logic as above, but for runner B. If runner B reaches the end of its track...
                pointerB = headA; // ...it starts running on track A!
            } else {
                pointerB = pointerB.next; // Otherwise, runner B continues to the next node on its track.
            }
        }

        return pointerA; // If the runners meet (pointerA == pointerB), we've found the intersection! Return that node. If the lists don't intersect at all, both runners will be null, and we return null.
    }


    // Main method to test the function
    public static void main(String[] args) {
        Optimize solution = new Optimize();

        // Shared part of the list (intersection)
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(10);

        // First list: 3 -> 7 -> 8 -> 10
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = intersection;


        // Second list: 99 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(99);
        headB.next = new ListNode(1);
        headB.next.next = intersection;

        // Call the function
        ListNode result = solution.getIntersectionNode(headA, headB);

        // Print result
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }
    }

}







