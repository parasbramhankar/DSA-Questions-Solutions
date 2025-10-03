package LinkedList.SinglyLinkedList.Medium.RemoveNthNodeFromEndofList19;

/**
 * ------------------------------------------------------------------------------------------------
 * Approach & Logic to remove the Nth node from the end of a linked list:
 * ------------------------------------------------------------------------------------------------
 * 1. Calculate the total length of the linked list by traversing it once.
 *    - Use a temporary pointer to iterate through the list, incrementing a counter.
 *
 * 2. Identify the position of the node to remove from the front of the list:
 *    - This is found as (length - N).
 *    - If N is greater than the list length, return the list unchanged.
 *
 * 3. Handle special case: if the node to remove is the head (i.e. length == N),
 *    return the head's next node because the head itself must be removed.
 *
 * 4. Otherwise traverse again up to the node *before* the target node (position length - N - 1).
 *    Use a loop to reach this previous node.
 *
 * 5. Remove the Nth node by changing the next pointer of the previous node to skip the target node.
 *    This effectively deletes the target node from the list.
 *
 * 6. Return the head of the updated list.
 *
 *---------------------------------------------------------------------------------------------
 * Dry Run Examples:
 *---------------------------------------------------------------------------------------------
 * Example 1: List = [1 -> 2 -> 3 -> 4 -> 5], N = 2
 * - Length = 5
 * - Node to remove = 5 - 2 = 3rd index (0-based), which is value 4
 * - Traverse to node 3 (value 3), set its next to skip node 4 and point to node 5
 * - New list: 1 -> 2 -> 3 -> 5
 *
 * Example 2: List = [10 -> 20 -> 30], N = 3
 * - Length = 3
 * - Node to remove = head (3 == length)
 * - Remove head by returning head.next
 * - New list: 20 -> 30
 *
 * This approach uses two passes through the list and constant extra space.
 */


public class Solution_1 {

    static int findTheLengthOfTheList(Node head){
        Node temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }


    static Node removeNthFromEnd(Node head, int n) {

        if (head == null) {
            return null;
        }

        int length = findTheLengthOfTheList(head);

        // If n is greater than the length, return head as is
        if (length < n) {
            return head;
        }

        // If the node to remove is the head node
        if (length == n) {
            return head.next;
        }

        int rem = length - n; // position of the node before the target

        Node temp = head;
        // Move temp to the node just before the one to delete
        for (int i = 1; i < rem; i++) {
            temp = temp.next;
        }

        // Remove the nth node from the end
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
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

        head=removeNthFromEnd(head,2);

        System.out.println("After removing the node:");
        display(head);

    }
}