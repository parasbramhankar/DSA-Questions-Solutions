package LinkedList.SinglyLinkedList.Medium.RemoveNthNodeFromEndofList19;


    /**
     * ✅ Problem: Remove N-th Node From End of List
     *
     * You are given the head of a linked list and an integer n.
     * Remove the n-th node from the end of the list and return its head.
     *
     * Example:
     * Input:  head = [1, 2, 3, 4, 5], n = 2
     * Output: [1, 2, 3, 5]
     *
     * ------------------------------------------------------------------------------------------
     * ✅ Approach: Two Pointer Technique (Fast and Slow Pointer)
     * ------------------------------------------------------------------------------------------
     * 1. Create a dummy node pointing to head. This helps in edge cases like deleting the head node.
     * 2. Use two pointers: `first` and `second`, both starting from the dummy node.
     * 3. Move the `first` pointer (n + 1) steps ahead. This creates a gap of `n` between the two pointers.
     * 4. Now move both `first` and `second` one step at a time until `first` reaches the end.
     * 5. At this point, `second` is just before the node we want to delete.
     * 6. Change the link: `second.next = second.next.next` to skip the target node.
     * 7. Return `dummy.next` as the new head of the list.
     *
     * ------------------------------------------------------------------------------------------
     * ✅ Time Complexity: O(L), where L is the length of the linked list.
     * ✅ Space Complexity: O(1), using only a few pointers.
     *
     * ------------------------------------------------------------------------------------------
     * ✅ Dry Run Example:
     * Input: head = [1, 2, 3, 4, 5], n = 2
     *
     * Step 1: dummy → 1 → 2 → 3 → 4 → 5
     *         ↑
     *      (both first and second at dummy initially)
     *
     * Step 2: Move first pointer 3 steps ahead (n + 1 = 3)
     *   i = 0 → first = 1
     *   i = 1 → first = 2
     *   i = 2 → first = 3
     *
     * Step 3: Move both pointers until first reaches null:
     *   first = 4 → second = 1
     *   first = 5 → second = 2
     *   first = null → second = 3
     *
     * Step 4: Now second is before node 4. Do:
     *   second.next = second.next.next → skip node 4
     *
     * Final list: [1, 2, 3, 5]
     *
     * ------------------------------------------------------------------------------------------
     * ✅ Edge Case:
     * Input: head = [1], n = 1
     * dummy → 1
     * Move first 2 steps → null
     * second is at dummy
     * Do: second.next = second.next.next → dummy.next = null
     * Final list: []
     *
     */

    public class Solution_2 {
       static public Node removeNthNodeFromLast(Node head, int n) {
            // Step 1: Create a dummy node that points to the head
            // This helps in cases where we might need to delete the head node itself
            Node dummy = new Node(0);
            dummy.next = head;

            // Step 2: Initialize two pointers, both starting at dummy
            Node first = dummy;
            Node second = dummy;

            // Step 3: Move the first pointer n+1 steps ahead
            // This creates a gap of 'n' nodes between first and second
            for (int i = 0; i <= n; i++) {
                first = first.next;
            }

            // Step 4: Move both pointers one step at a time until the first reaches the end
            // At this point, second pointer will be just before the node to be deleted
            while (first != null) {
                first = first.next;
                second = second.next;
            }

            // Step 5: Skip the target node
            second.next = second.next.next;

            // Step 6: Return the updated list
            return dummy.next;
        }

        public static void display(Node head) {
            while (head != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }

        public static void main(String[] args) {
            Node head=new Node(10);
            head.next=new Node(20);
            head.next.next=new Node(30);
            head.next.next.next=new Node(40);
            head.next.next.next.next=new Node(50);

            System.out.println("Before removing the nth node from the last: ");
            display(head);

            head=removeNthNodeFromLast(head,2);

            System.out.println("After removing the node:");
            display(head);

        }
}