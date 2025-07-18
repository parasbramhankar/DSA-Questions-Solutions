package LinkedList.SinglyLinkedList.Easy.MiddleOfTheLinkedList876;


/***
 * Algorithm / Intuition
 * Using the brute force approach, we can find the middle node of a linked list by traversing the linked list and finding the total number of nodes as `count`. Then we reset the traversal pointer and traverse to the node at the [count/2 + 1]th position. That will be the middle node.
 *
 * Algorithm:
 *
 * Step 1: Initialise pointer temp to the head of the linked list and a variable to count to hold
 * the number of nodes in the linked list. Using temp traverse the linked list, increasing the
 * value of count by one at each node till temp becomes null. The final value of count will
 * represent the length of the linked list.
 *
 * Step 2: Calculate mid as count/2 + 1 where count is the length of the linked list.
 * Mid represents the position of the middle node.
 *
 * Step 3: Reset a temp pointer back to the head and traverse the list by iteratively
 * moving temp mid-number of times. The node pointed to by current after this traversal is the
 * middle node of the linked list.
 *
 * see: MiddleOfTheLinkedList876/BruteForce_Image 1.png
 */
public class BruteForce {
    // Function to find the middle node of a linked list
    static ListNode findMiddle(ListNode head) {
        // If the list is empty or has
        // only one element, return the head as
        // it's the middle.
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        int count = 0;

        // Count the number of nodes
        // in the linked list.
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Calculate the position of the middle node.
        int mid = count / 2 + 1;
        temp = head;

        while (temp != null) {
            mid = mid - 1;

            // Check if the middle
            // position is reached.
            if (mid == 0){
                // break out of the loop
                // to return temp
                break;
            }
            // Move temp ahead
            temp = temp.next;
        }

        // Return the middle node.
        return temp;
    }

    public static void main(String[] args) {
        // Creating a sample linked list:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Find the middle node
        ListNode middleNode = findMiddle(head);

        // Display the value of the middle node
        System.out.println("The middle node value is: " + middleNode.data);
    }
}
