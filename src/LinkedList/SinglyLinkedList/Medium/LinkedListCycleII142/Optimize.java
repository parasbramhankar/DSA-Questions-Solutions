package LinkedList.SinglyLinkedList.Medium.LinkedListCycleII142;

public class Optimize {
    static public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                break;
            }

        }

        if (fast== null || fast.next == null) {
            return null;
        }

        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }

        return slow;

    }
    public static void main(String[] args) {
        // Creating nodes
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating a cycle back to node with value 2

        ListNode result = detectCycle(head);
        if (result != null) {
            System.out.println("Cycle starts at node with value: " + result.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
