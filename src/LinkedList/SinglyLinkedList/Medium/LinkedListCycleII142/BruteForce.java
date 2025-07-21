package LinkedList.SinglyLinkedList.Medium.LinkedListCycleII142;

//Using O(n) space

import java.util.HashSet;
import java.util.Set;

public class BruteForce {

    static public ListNode detectCycle(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();

        while (head != null) {
            if (hashSet.contains(head)) {
                return head;
            }
            hashSet.add(head);
            head = head.next;
        }

        return null;
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
