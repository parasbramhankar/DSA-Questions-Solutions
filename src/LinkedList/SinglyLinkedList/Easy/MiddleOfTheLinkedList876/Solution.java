package LinkedList.SinglyLinkedList.Easy.MiddleOfTheLinkedList876;

public class Solution {
    static void display(ListNode head) {
        ListNode temp = head;

        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println(temp.data);  // this is done only for the -> to print after the element
        // If we do not want to add, "->", then we can use the  while(temp!=null)
        //which iterate up to the last element of the linked list
        System.out.println();
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
