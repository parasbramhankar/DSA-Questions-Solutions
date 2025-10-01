package LinkedList.SinglyLinkedList.Easy.ReverseALinkedList206;

public class RecursiveSolution {

    //  Step 1: Define ListNode class for a linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to reverse a singly linked list
    static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode newHead=reverseList(head.next);
        ListNode next=head.next;
        next.next=head;
        head.next=null;
        return newHead;
    }


    //  Step 3: Utility method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //  Step 4: Main method to run and test the reverse logic
    public static void main(String[] args) {

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print original list
        System.out.println("Original Linked List:");
        printList(head);

        //Reverse the linked list
        ListNode reversedHead = reverseList(head);

        //Print reversed list
        System.out.println("\nReversed Linked List:");
        printList(reversedHead);
    }
}