package LinkedList.SinglyLinkedList.Medium.DeleteNodeInLinkedList237;

/***
 * Approach:
 * The main intuition is to point the second last node to null to get the updated linked list.
 * Hence, we will iterate till the second last node and make it point to NULL.
 * This will effectively skip the last node of the list therefore,
 *
 * Two edge cases to consider are:
 *
 * If the input linked list is empty, we return null.
 * If there is only one node in the list, that node itself will be the tail, therefore we return null after deleting that node.
 *
 * Algorithm:
 * 1. Start by initializing a pointer to the head of the list that will be used to iterate through the
 * linked list. Iterate up to the second last node, this node will be our new tail of the list.
 *
 *---------> Image 1: src/LinkedList/SinglyLinkedList/Medium/DeleteNodeInLinkedList237/1.jpg
 *
 * After reaching the second-to-last node, free up the memory occupied by the former tail or the lastnode of the list.
 * Note: In the case of languages like Java, Python, and Javascript, there is no need for the deletion of objects or
 * nodes because these have an automatic garbage collection mechanism that automatically identifies and reclaims
 * memory that is no longer in use.
 *
 * ---------> Image 2 : src/LinkedList/SinglyLinkedList/Medium/DeleteNodeInLinkedList237/2.jpg
 *
 * Finally, point the second last node or the new tail to NULL to obtain the updated linked list.
 *
 * ---------> Image 3: src/LinkedList/SinglyLinkedList/Medium/DeleteNodeInLinkedList237/3.jpg
 *
 */







// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    // Function to delete a node (without head reference)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Helper function to print linked list
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Driver function for testing
    public static void main(String[] args) {
        // Build linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        Solution sol = new Solution();
        System.out.print("Original list: ");
        sol.printList(head);

        // Suppose we want to delete node with value 5
        ListNode nodeToDelete = head.next; // node with value 5
        sol.deleteNode(nodeToDelete);

        System.out.print("After deleting 5: ");
        sol.printList(head);
    }
}
